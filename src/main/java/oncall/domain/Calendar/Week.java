package oncall.domain.Calendar;

import java.util.ArrayList;
import java.util.List;

public enum Week {
    SUNDAY("일", true),
    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true);

    private final String day;
    private final boolean isWeekEnd;

    Week(String day, boolean isWeekEnd) {
        this.day = day;
        this.isWeekEnd = isWeekEnd;
    }

    public String day() {
        return day;
    }

    public boolean isWeekEnd() {
        return isWeekEnd;
    }

    public static List<Week> getOrderedDaysStartingFrom(String startDay) {
        Week start = findDayOfWeekByKoreanName(startDay);
        if (start != null) {
            return addOrderedDaysToList(start);
        }
        return new ArrayList<>();
    }

    private static Week findDayOfWeekByKoreanName(String koreanName) {
        for (Week day : Week.values()) {
            if (day.day().equals(koreanName)) {
                return day;
            }
        }
        return null;
    }

    private static List<Week> addOrderedDaysToList(Week startDay) {
        List<Week> orderedDays = new ArrayList<>();
        addDaysFromStartDay(orderedDays, startDay);
        addDaysBeforeStartDay(orderedDays, startDay);
        return orderedDays;
    }

    private static void addDaysFromStartDay(List<Week> orderedDays, Week startDay) {
        boolean started = false;
        for (Week day : Week.values()) {
            if (day == startDay || started) {
                orderedDays.add(day);
                started = true;
            }
        }
    }

    private static void addDaysBeforeStartDay(List<Week> orderedDays, Week startDay) {
        for (Week day : Week.values()) {
            if (day == startDay) {
                break;
            }
            orderedDays.add(day);
        }
    }

}
