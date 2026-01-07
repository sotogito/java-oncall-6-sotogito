package oncall.controller;

import java.util.List;
import oncall.domain.OnCallDate;
import oncall.domain.OnCallScheduler;
import oncall.domain.WorkType;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.service.OnCallService;
import oncall.view.ExceptionHandler;
import oncall.view.InputView;

public class OnCallController {
    private final OnCallService onCallService = new OnCallService();

    /**
     * 날짜 받으면 피룡한거
     * - 받는 날짜 : 월, 요일
     * 월
     * 요일 : 주말인지 - DayOdWeekKorean(E)
     * 해당 달이 며칠까지 있는지 - yearMonth.lengthOfMonth();
     * 해달 달의 시작 요일이 맞는지 - LocalDate.of(2023,1,1) ->  onCallDate.getDayOfWeek() -> DayOdWeekKorean
     */
    public void main() {
        OnCallScheduler onCallScheduler = createOnCallScheduler();
        Workers workers = createWorkers();
        System.out.println(workers);

    }

    private Workers createWorkers() {
        while (true) {
            try {
                List<Worker> weekdayWorkers = InputView.readWeekdayWorkers().stream()
                        .map(workerNickname -> new Worker(workerNickname, WorkType.WEEKDAY))
                        .toList();
                List<Worker> weekendWorkers = InputView.readWeekendWorkers().stream()
                        .map(workerNickname -> new Worker(workerNickname, WorkType.WEEKEND))
                        .toList();

                return Workers.createWeekdayWeekendWorkers(weekdayWorkers, weekendWorkers);
            } catch (IllegalArgumentException e) {
                ExceptionHandler.read(e);
            }
        }
    }

    private OnCallScheduler createOnCallScheduler() {
        while (true) {
            try {
                OnCallDate onCallDate = InputView.readOnCallDate();

                return OnCallScheduler.create(
                        onCallDate.month(),
                        onCallDate.dayOfWeek()
                );
            } catch (IllegalArgumentException e) {
                ExceptionHandler.read(e);
            }
        }
    }

}
