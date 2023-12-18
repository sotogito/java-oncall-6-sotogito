package oncall.controller;

import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;
import oncall.domain.manager.member.WeekdayOnCallMember;
import oncall.domain.manager.member.WeekendOnCallMember;
import oncall.view.InputView;
import oncall.view.OutputView;


public class OnCallController {

    public void run() {
        CalendarManager calendarManager = createCalendarManager();
        MemberManager memberManager = createMemberManager();


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

    private OnCallPrinter runOnCallPrinter(CalendarManager calendarManager, MemberManager memberManager) {
        return new OnCallPrinter(calendarManager, memberManager);
    }

}
