package oncall.domain;

import java.time.DateTimeException;
import java.time.LocalDate;

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

    @Override
    public String toString() {
        return date + dayOfWeekKorean.getKorean();
    }

}
