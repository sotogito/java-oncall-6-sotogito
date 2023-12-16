package oncall.controller;

import oncall.domain.Calendar.DayInfo;
import oncall.domain.Calendar.MonthInfo;
import oncall.domain.Calendar.PublicHolidayInfo;
import oncall.domain.CalendarManager;
import oncall.domain.MemberManager;

import java.util.List;

public class OnCallPrinter {
    CalendarManager calendarManager;
    MemberManager memberManager;
    int month;
    List<Integer> dayList;
    List<DayInfo> weekday;
    List<String> weekdayMember;
    List<String> weekendMember;


    public OnCallPrinter(CalendarManager calendarManager, MemberManager memberManager) {
        this.calendarManager = calendarManager;
        this.memberManager = memberManager;
        month = calendarManager.getMonth();
        dayList = MonthInfo.getDaysOfMonth(month);
        weekday = DayInfo.getOrderedDaysStartingFrom(calendarManager.getDay());
        weekdayMember = memberManager.getWeekdayOnCall();
        weekendMember = memberManager.getWeekendOnCall();
    }

    public void print(){
        int monthData = month;
        int dayData;
        String weekdayData;
        DayInfo dayInfo;
        String member="";
        int weekdayIndex=0;
        int weekendindax=0;


        for (int i = 0; i < dayList.size(); i++) {
            dayData = dayList.get(i);
            weekdayData = weekday.get(i % weekday.size()).day();
            if(PublicHolidayInfo.isHoliday(monthData,dayData)){ //휴일 판별
                weekdayData += "(휴일)";
            }
            if(!weekday.get(i % weekday.size()).isWeekEnd()){
                member = weekdayMember.get(weekdayIndex%weekdayMember.size());
                weekdayIndex++;
            } else if (weekday.get(i % weekday.size()).isWeekEnd()) {
                member = weekendMember.get(weekendindax%weekendMember.size());
                weekendindax++;

            }


            System.out.println(monthData+"월 "+dayData+"일 "+weekdayData+" "+member);

        }

        //달 : calendarManager.getMonth();
        //일 :


    }












    public void printq() {
        int account = MonthInfo.getNumberOfDays(calendarManager.getMonth());
        List<DayInfo> sortedWeekDay = DayInfo.getOrderedDaysStartingFrom(calendarManager.getDay());
        List<String> weekdayMember = memberManager.getWeekdayOnCall();
        List<String> weekendMember = memberManager.getWeekendOnCall();

        String previousMember = "";
        for (int i = 0; i < account; i++) {
            DayInfo dayInfo = sortedWeekDay.get(i % sortedWeekDay.size());
            String member;

            if (dayInfo.isWeekEnd()) {
                member = getNextMember(weekendMember, previousMember);
            } else {
                member = getNextMember(weekdayMember, previousMember);
            }

            System.out.println(String.format("5월 %d일 %s %s", i + 1, dayInfo.day(), member));
            previousMember = member;
        }
    }

    private String getNextMember(List<String> members, String previousMember) {
        for (String member : members) {
            if (!member.equals(previousMember)) {
                return member;
            }
        }
        return members.get(0); // Fallback, should not happen if members list is correctly set up
    }


}
