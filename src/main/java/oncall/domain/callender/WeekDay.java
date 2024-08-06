package oncall.domain.callender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WeekDay {
    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true),
    SUNDAY("일", true);

    private final String koreanName;
    private final boolean isWeekend;

    WeekDay(String koreanName, boolean isWeekend) {
        this.koreanName = koreanName;
        this.isWeekend = isWeekend;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public static List<WeekDay> getWeekDay(String startDay){
        List<WeekDay> weekDaysList = new ArrayList<>();
        WeekDay[] weekDays = WeekDay.values();

        // startDay를 WeekDay 열거형으로 변환
        WeekDay startWeekDay = null;
        for (WeekDay day : weekDays) {
            if (day.getKoreanName().equals(startDay)) {
                startWeekDay = day;
                break;
            }
        }

        if (startWeekDay == null) {
            throw new IllegalArgumentException("유효하지 않은 요일입니다: " + startDay);
        }

        int startIndex = startWeekDay.ordinal();

        // 주의 모든 요일을 계산하여 List에 추가
        for (int i = 0; i < weekDays.length; i++) {
            WeekDay currentDay = weekDays[(startIndex + i) % weekDays.length];
            weekDaysList.add(currentDay);
        }

        return weekDaysList;
    }





}
