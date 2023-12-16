package oncall.domain;

import oncall.domain.Calendar.MonthInfo;

import java.util.List;

public class CalendarManager {
    private final int month;
    private final String day;

    public CalendarManager(List<String> date) {
        int monthData = Integer.parseInt(date.get(0));
        String dayData = date.get(1);
        MonthInfo.exists(monthData, dayData);
        this.month = monthData;
        this.day = dayData;

    }

    public int getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

}
