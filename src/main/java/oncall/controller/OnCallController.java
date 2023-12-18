package oncall.controller;

import oncall.domain.*;
import oncall.domain.Calendar.Month;
import oncall.domain.Calendar.PublicHoliday;
import oncall.domain.Calendar.Week;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;
import oncall.domain.manager.member.WeekdayOnCallMember;
import oncall.domain.manager.member.WeekendOnCallMember;
import oncall.util.OnCallDayMaker;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class OnCallController {

    int weekdayIndex = 0;
    int weekendIndex = 0;

    public void run() {
        CalendarManager calendarManager = createCalendarManager();
        MemberManager memberManager = createMemberManager();

        OnCallScheduler onCallScheduler = createOnCallScheduler(calendarManager,memberManager);

        for(OnCallDayEntry data : onCallScheduler.getOnCallList()){
            System.out.println(data.getMonth()+"월 "+data.getDay()+"일 "+data.getDayOfWeek()+" "+data.getMember());
        }


    }

    private OnCallScheduler createOnCallScheduler(CalendarManager calendarManager,MemberManager memberManager){
        OnCallMemberMaker weekdayMemberMaker = new WeekdayScheduler();
        OnCallMemberMaker weekendMemberMaker = new WeekendScheduler();



        List<OnCallDayEntry> result = new ArrayList<>();

        int month = calendarManager.getMonth();
        int dayCount = Month.getNumberOfDays(calendarManager.getMonth());
        List<Week> weekList = Week.getOrderedDaysStartingFrom(calendarManager.getDay());

        for(int i=1; i<=dayCount; i++){
            OnCallDayMaker onCallDayMaker = createOnCallMemberMaker(weekdayMemberMaker,weekendMemberMaker);
            OnCallDayEntry member = onCallDayMaker.runMaker(month,i,weekList.get((i-1)%weekList.size()),memberManager);
            result.add(member);
        }
        return new OnCallScheduler(result);
    }

    private OnCallDayMaker createOnCallMemberMaker(OnCallMemberMaker weekday, OnCallMemberMaker weekend){
        return new OnCallDayMaker(weekday,weekend);
    }





    private CalendarManager createCalendarManager() {
        try {
            return new CalendarManager(InputView.inputMonthDay());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createCalendarManager();
        }
    }

    private MemberManager createMemberManager() {
        try {
            return new MemberManager(createWeekdayOnCall(), createWeekendOnCall());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createMemberManager();
        }

    }

    private WeekdayOnCallMember createWeekdayOnCall() {
        return new WeekdayOnCallMember(InputView.inputWeekdayMember());
    }

    private WeekendOnCallMember createWeekendOnCall() {
        return new WeekendOnCallMember(InputView.inputWeekendMemebr());
    }




}
