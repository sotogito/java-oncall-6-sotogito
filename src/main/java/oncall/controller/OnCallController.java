package oncall.controller;

import oncall.domain.maker.OnCallMemberMaker;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;
import oncall.domain.manager.member.WeekdayOnCallMember;
import oncall.domain.manager.member.WeekendOnCallMember;
import oncall.domain.scheduler.OnCallDayEntry;
import oncall.domain.scheduler.OnCallScheduler;
import oncall.domain.scheduler.WeekdayScheduler;
import oncall.domain.scheduler.WeekendScheduler;
import oncall.domain.maker.OnCallSchedulerMaker;
import oncall.view.InputView;
import oncall.view.OutputView;


public class OnCallController {


    public void run() {
        CalendarManager calendarManager = createCalendarManager();
        MemberManager memberManager = createMemberManager();
        OnCallScheduler onCallScheduler = createOnCallScheduler(calendarManager,memberManager);

        OnCallPrinter.runPrinter(onCallScheduler);
    }


    private OnCallScheduler createOnCallScheduler(CalendarManager calendarManager,MemberManager memberManager){
        OnCallMemberMaker weekdayMemberMaker = new WeekdayScheduler();
        OnCallMemberMaker weekendMemberMaker = new WeekendScheduler();
        //index 초기화

        OnCallSchedulerMaker maker = new OnCallSchedulerMaker(weekdayMemberMaker,weekendMemberMaker);
        return maker.runMaker(calendarManager,memberManager);
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
