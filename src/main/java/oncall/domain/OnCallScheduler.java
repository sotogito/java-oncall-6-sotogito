package oncall.domain;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnCallScheduler {
    private final LocalDate date; //2023
    private final DayOfWeekKorean dayOfWeekKorean;

    private OnCallScheduler(LocalDate date, DayOfWeekKorean dayOfWeekKorean) {
        this.date = date;
        this.dayOfWeekKorean = dayOfWeekKorean;
    }

    public static OnCallScheduler create(int month, String dayOfWeekStr) {
        LocalDate localDate;
        try {
            localDate = LocalDate.of(2023, month, 1);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("날짜를(달) 다시 입력해주세요.");
        }

        DayOfWeekKorean dayOfWeek = DayOfWeekKorean.find(dayOfWeekStr);
        if (localDate.getDayOfWeek() != dayOfWeek.getDayOfWeek()) {
            throw new IllegalArgumentException("날짜를(요일) 다시 입력해주세요.");
        }

        return new OnCallScheduler(localDate, dayOfWeek);
    }


    public List<Worker> schedule(Workers workers) {
        List<Worker> onCall = new ArrayList<>();

        List<Worker> weekday = workers.getWorkersByWorkType(WorkType.WEEKDAY);
        List<Worker> weekend = workers.getWorkersByWorkType(WorkType.WEEKEND);

        int weekdayIndex = 0;
        int weekendIndex = 0;

        int totalDays = date.lengthOfMonth();

        System.out.println(totalDays);

        LocalDate workDate = this.date;
        int dayCount = 1;
        do {
            DayOfWeekKorean dayOfWeekKorean = DayOfWeekKorean.find(workDate.getDayOfWeek());

            if (dayOfWeekKorean.isWeekend()) {
                onCall.add(weekend.get(weekendIndex)
                        .newWorker(
                                workDate,
                                WorkType.WEEKEND
                        ));
                weekendIndex = (weekendIndex + 1) % weekend.size();
            } else {
                if (LegalHoliday.isLegalHoliday(workDate)) {
                    onCall.add(weekend.get(weekendIndex)
                            .newWorker(
                                    workDate,
                                    WorkType.HOLIDAY
                            ));
                    weekendIndex = (weekendIndex + 1) % weekend.size();
                } else {
                    onCall.add(weekday.get(weekdayIndex)
                            .newWorker(
                                    workDate,
                                    WorkType.WEEKDAY
                            ));
                    weekdayIndex = (weekdayIndex + 1) % weekday.size();
                }
            }

            workDate = workDate.plusDays(1);
            dayCount++;
        } while (dayCount <= totalDays);

        /// 연속 변경해야됨
        processContinuousWork(onCall);

        Collections.sort(onCall);
        return onCall;
    }

    //1,2,3,3,5
    private void processContinuousWork(List<Worker> workers) {

        Worker before = null;
        Worker target = null;

        for (Worker worker : workers) {
            if (target != null) {
                target.change(worker);

                before = target;
                target = null;
                continue;
            }
            if (worker.equals(before)) {
                target = worker;
            }
            before = worker;
        }
    }


    @Override
    public String toString() {
        return date + dayOfWeekKorean.getKorean();
    }

}
