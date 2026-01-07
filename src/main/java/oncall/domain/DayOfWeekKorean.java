package oncall.domain;

import java.time.DayOfWeek;
import java.util.Objects;

public enum DayOfWeekKorean {
    월(DayOfWeek.MONDAY, "월", false),
    화(DayOfWeek.TUESDAY, "화", false),
    수(DayOfWeek.WEDNESDAY, "수", false),
    목(DayOfWeek.THURSDAY, "목", false),
    금(DayOfWeek.FRIDAY, "금", false),
    토(DayOfWeek.SATURDAY, "토", true),
    일(DayOfWeek.SUNDAY, "일", true);

    private final DayOfWeek dayOfWeek;
    private final String korean;
    private final boolean isWeekend;

    DayOfWeekKorean(DayOfWeek dayOfWeek, String korean, boolean isWeekend) {
        this.dayOfWeek = dayOfWeek;
        this.korean = korean;
        this.isWeekend = isWeekend;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getKorean() {
        return korean;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public int getIndex() {
        return this.ordinal();
    }

    public static DayOfWeekKorean find(String dayOfWeek) {
        for (DayOfWeekKorean dayOfWeekKorean : DayOfWeekKorean.values()) {
            if (Objects.equals(dayOfWeekKorean.korean, dayOfWeek)) {
                return dayOfWeekKorean;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 요일입니다.");
    }

    public static DayOfWeekKorean find(DayOfWeek dayOfWeek) {
        for (DayOfWeekKorean dayOfWeekKorean : DayOfWeekKorean.values()) {
            if (Objects.equals(dayOfWeekKorean.dayOfWeek, dayOfWeek)) {
                return dayOfWeekKorean;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 요일입니다.");
    }

}
