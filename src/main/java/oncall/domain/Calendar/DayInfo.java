package oncall.domain.Calendar;

import java.util.ArrayList;
import java.util.List;

public enum DayInfo {
    SUNDAY("일",true),
    MONDAY("월",false),
    TUESDAY("화",false),
    WEDNESDAY("수",false),
    THURSDAY("목",false),
    FRIDAY("금",false),
    SATURDAY("토",true);

    private final String day;
    private final boolean isWeekEnd;

    DayInfo(String day,boolean isWeekEnd) {
        this.day = day;
        this.isWeekEnd = isWeekEnd;
    }

    public String day() {
        return day;
    }

    public boolean isWeekEnd(){
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
        boolean started = false;

        // 시작 요일부터 순서대로 리스트에 추가
        for (DayInfo day : DayInfo.values()) {
            if (day == startDay || started) {
                orderedDays.add(day);
                started = true;
            }
        }

        // 시작 요일 이전의 요일을 순서대로 리스트에 추가
        for (DayInfo day : DayInfo.values()) {
            if (day == startDay) {
                break;
            }
            orderedDays.add(day);
        }

        return orderedDays;
    }


}
