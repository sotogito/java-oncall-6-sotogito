package oncall.domain.manager;

import oncall.domain.Calendar.Month;

import java.util.List;

public class CalendarManager {
    private final int month;
    private final String day;

    public CalendarManager(List<String> date) {
        int monthData = Integer.parseInt(date.get(0));
        String dayData = date.get(1);
        Month.exists(monthData, dayData);
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
