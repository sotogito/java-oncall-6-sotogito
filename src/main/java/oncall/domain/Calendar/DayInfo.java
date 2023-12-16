package oncall.domain.Calendar;

import java.util.ArrayList;
import java.util.List;

public enum DayInfo {
    SUNDAY("일", true),
    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true);

    private final String day;
    private final boolean isWeekEnd;

    DayInfo(String day, boolean isWeekEnd) {
        this.day = day;
        this.isWeekEnd = isWeekEnd;
    }

    public String day() {
        return day;
    }

    public boolean isWeekEnd() {
        return isWeekEnd;
    }

    public static List<DayInfo> getOrderedDaysStartingFrom(String startDay) {
        DayInfo start = findDayOfWeekByKoreanName(startDay);
        if (start != null) {
            return addOrderedDaysToList(start);
        }
        return new ArrayList<>();
    }

    private static DayInfo findDayOfWeekByKoreanName(String koreanName) {
        for (DayInfo day : DayInfo.values()) {
            if (day.day().equals(koreanName)) {
                return day;
            }
        }
        return null;
    }

    private static List<DayInfo> addOrderedDaysToList(DayInfo startDay) {
        List<DayInfo> orderedDays = new ArrayList<>();
        addDaysFromStartDay(orderedDays, startDay);
        addDaysBeforeStartDay(orderedDays, startDay);
        return orderedDays;
    }

    private static void addDaysFromStartDay(List<DayInfo> orderedDays, DayInfo startDay) {
        boolean started = false;
        for (DayInfo day : DayInfo.values()) {
            if (day == startDay || started) {
                orderedDays.add(day);
                started = true;
            }
        }
    }

    private static void addDaysBeforeStartDay(List<DayInfo> orderedDays, DayInfo startDay) {
        for (DayInfo day : DayInfo.values()) {
            if (day == startDay) {
                break;
            }
            orderedDays.add(day);
        }
    }

}
