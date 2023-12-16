package oncall.domain;

import java.util.List;

public class CalendarManager {
    private int month;
    private String day;
    //List<String>으로 받아서 분리 후 저장

    public CalendarManager(List<String> date) {
        //MonthInfo에 존재하는 조합인지 확인

        this.month = Integer.parseInt(date.get(0));
        this.day = date.get(1);

    }

    public int getMonth(){
        return month;
    }
    public String getDay(){
        return day;
    }


}
