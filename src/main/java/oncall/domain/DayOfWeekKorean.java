package oncall.domain;

import java.time.DayOfWeek;
import java.util.Objects;

public enum DayOfWeekKorean {
    월(DayOfWeek.MONDAY, "월", false),
    화(DayOfWeek.THURSDAY, "화", false),
    수(DayOfWeek.WEDNESDAY, "수", false),
    목(DayOfWeek.THURSDAY, "목", false),
    금(DayOfWeek.FRIDAY, "금", false),
    토(DayOfWeek.SATURDAY, "토", true),
    일(DayOfWeek.SUNDAY, "일", true);

    private final DayOfWeek dayOfWeek;
    private final String korean;
    private final boolean isHoliday;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getKorean() {
        return korean;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    DayOfWeekKorean(DayOfWeek dayOfWeek, String korean, boolean isHoliday) {
        this.dayOfWeek = dayOfWeek;
        this.korean = korean;
        this.isHoliday = isHoliday;
    }

    public static DayOfWeekKorean find(String dayOfWeek) {
        for (DayOfWeekKorean dayOfWeekKorean : DayOfWeekKorean.values()) {
            if (Objects.equals(dayOfWeekKorean.korean, dayOfWeek)) {
                return dayOfWeekKorean;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 요일입니다.");
    }

}
