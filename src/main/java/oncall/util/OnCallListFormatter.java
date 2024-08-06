package oncall.util;


import oncall.domain.schedule.Day;

public class OnCallListFormatter {
    private final static String ON_CALL_FORMAT = "%d월 %d일 %s %s";
    private final static String ON_CALL_HOLIDAY_FORMAT = "%d월 %d일 %s(휴일) %s";


    public static String format(Day day){
        int monthPrintout = day.getMonth();
        int dayPrintout = day.getDay();
        String dayOfWeekPrintout = day.getDayOfWeek();
        String staffName = day.getStaff().getName();

        if(day.isAddHolidayMark()){
            return String.format(ON_CALL_HOLIDAY_FORMAT,monthPrintout,dayPrintout,dayOfWeekPrintout,staffName);
        }
        return String.format(ON_CALL_FORMAT,monthPrintout,dayPrintout,dayOfWeekPrintout,staffName);
    }


}
