package oncall.util;

import oncall.domain.*;
import oncall.domain.Calendar.Month;
import oncall.domain.Calendar.PublicHoliday;
import oncall.domain.Calendar.Week;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;

import java.util.ArrayList;
import java.util.List;

public class OnCallSchedulerMaker {
    private final OnCallMemberMaker weekdayMemberMaker;
    private final OnCallMemberMaker weekendMemberMaker;

    public OnCallSchedulerMaker(OnCallMemberMaker weekday, OnCallMemberMaker weekend) {
        weekdayMemberMaker = weekday;
        weekendMemberMaker = weekend;
    }

    public OnCallScheduler runMaker(CalendarManager calendarManager, MemberManager memberManager) {
        List<OnCallDayEntry> result = new ArrayList<>();

        int month = calendarManager.getMonth();
        int dayCount = Month.getNumberOfDays(calendarManager.getMonth());
        List<Week> weekList = Week.getOrderedDaysStartingFrom(calendarManager.getDay());

        for (int i = 1; i <= dayCount; i++) {
            OnCallDayEntry member = runDayEntryMaker(month, i, weekList.get((i - 1) % weekList.size()), memberManager);
            result.add(member);
        }

        return createOnCallScheduler(result);
    }


    public OnCallDayEntry runDayEntryMaker(int month, int day, Week dayOfWeek, MemberManager memberManager) {
        boolean isHoliday = PublicHoliday.isHoliday(month, day);
        String dayOfWeekData = getDayOfWeekData(isHoliday,dayOfWeek);
        String memberData = getMemberDate(isHoliday, dayOfWeek, memberManager);

        return createOnCallDayEntry(month, day, dayOfWeekData, memberData);
    }

    private String getDayOfWeekData(boolean isHoliday, Week dayOfWeek){
        String dayOfWeekData = dayOfWeek.day();
        if (!dayOfWeek.isWeekEnd() && isHoliday) {
            dayOfWeekData += "(휴일)";
        }
        return dayOfWeekData;
    }


    private String getMemberDate(boolean isHoliday, Week dayOfWeek, MemberManager memberManager) {
        if (dayOfWeek.isWeekEnd() || isHoliday) {
            return weekendMemberMaker.generate(memberManager.getWeekendOnCall());
        }
        return weekdayMemberMaker.generate(memberManager.getWeekdayOnCall());
    }

    private OnCallDayEntry createOnCallDayEntry(int month, int day, String dayWeek, String member) {
        return new OnCallDayEntry(month, day, dayWeek, member);
    }

    private OnCallScheduler createOnCallScheduler(List<OnCallDayEntry> members) {
        return new OnCallScheduler(members);

    }

}
