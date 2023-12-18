package oncall.util;

import oncall.domain.*;
import oncall.domain.Calendar.PublicHoliday;
import oncall.domain.Calendar.Week;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;

import java.util.List;

public class OnCallDayMaker {
    private final OnCallMemberMaker weekdayMemberMaker;
    private final OnCallMemberMaker weekendMemberMaker;
    boolean isHoliday;

    public OnCallDayMaker(OnCallMemberMaker weekday, OnCallMemberMaker weekend) {
        weekdayMemberMaker = weekday;
        weekendMemberMaker = weekend;
    }


    public OnCallDayEntry runMaker(int month, int day, Week dayOfWeek, MemberManager memberManager) {
        isHoliday = PublicHoliday.isHoliday(month, day);
        String dayOfWeekData = dayOfWeek.day();
        String memberData = "";

        if (!dayOfWeek.isWeekEnd() && !isHoliday) {
            memberData = weekdayMemberMaker.generate(memberManager.getWeekdayOnCall());
        } else if (dayOfWeek.isWeekEnd()) {
            memberData = weekendMemberMaker.generate(memberManager.getWeekendOnCall());
        }
        if (!dayOfWeek.isWeekEnd() && isHoliday) {
            memberData = weekendMemberMaker.generate(memberManager.getWeekendOnCall());
            dayOfWeekData += "(휴일)";
        }

        return createOnCallDayEntry(month, day, dayOfWeekData, memberData);
    }

    private OnCallDayEntry createOnCallDayEntry(int month, int day, String dayWeek, String member) {
        return new OnCallDayEntry(month, day, dayWeek, member);
    }

}
