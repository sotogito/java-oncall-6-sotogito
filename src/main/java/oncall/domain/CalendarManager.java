package oncall.domain;

import java.util.List;

public class CalendarManager {
    private int month;
    private String day;
    //List<String>으로 받아서 분리 후 저장

    public CalendarManager(List<String> date) {
        int monthData = Integer.parseInt(date.get(0));
        String dayData =  date.get(1);
        MonthInfo.exists(monthData,dayData);
        this.month = monthData;
        this.day = dayData;

    }

    public int getMonth(){
        return month;
    }
    public String getDay(){
        return day;
    }


}
