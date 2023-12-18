package oncall.controller;

import oncall.domain.Calendar.Week;
import oncall.domain.Calendar.Month;
import oncall.domain.Calendar.PublicHoliday;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;
import oncall.view.OutputView;

import java.util.List;

public class OnCallPrinter {
    /*
    private final int month; //월
    private final List<Integer> dayList; //일
    private final List<Week> weekdayList; //요일
    private final List<String> weekdayMember; //평일 콜온 멤버
    private final List<String> weekendMember; //주말 콜온 멤버


    public OnCallPrinter(CalendarManager calendarManager, MemberManager memberManager) {
        month = calendarManager.getMonth();
        dayList = Month.getDaysOfMonth(month);
        weekdayList = Week.getOrderedDaysStartingFrom(calendarManager.getDay());
        weekdayMember = memberManager.getWeekdayOnCall();
        weekendMember = memberManager.getWeekendOnCall();
    }

    public void print() {
        int weekdayIndex = 0;
        int weekendIndex = 0;
        String prevMember = "";
        duringMonth(weekdayIndex, weekendIndex, prevMember);
    }

    private void duringMonth(int weekdayIndex, int weekendIndex, String prevMember) {
        for (int i = 0; i < dayList.size(); i++) {
            String weekdayData = weekdayList.get(i % weekdayList.size()).day();
            String memberData = "";
            boolean isHoliday = checkHoliday(dayList.get(i), weekdayData);
            if (!weekdayList.get(i % weekdayList.size()).isWeekEnd() && !isHoliday) {
                memberData = getAdjustedMember(weekdayMember, prevMember, weekdayIndex);
                weekdayIndex = (weekdayIndex + 1) % weekdayMember.size();
            } else if (weekdayList.get(i % weekdayList.size()).isWeekEnd() || isHoliday) {
                memberData = getAdjustedMember(weekendMember, prevMember, weekendIndex);
                weekendIndex = (weekendIndex + 1) % weekendMember.size();
            }
            OutputView.printOnCallList(month, dayList.get(i), weekdayData, memberData);
            prevMember = memberData;
        }
    }

    private boolean checkHoliday(int dayData, String weekdayData) {
        boolean isHoliday = PublicHoliday.isHoliday(month, dayData);
        if (isHoliday) {
            weekdayData += "(휴일)";
        }
        return isHoliday;
    }

    private String getAdjustedMember(List<String> members, String prevMember, int currentIndex) {
        String nextMember = members.get(currentIndex % members.size());
        if (nextMember.equals(prevMember)) {
            return members.get((currentIndex + 1) % members.size());
        }
        return nextMember;
    }

 */

}
