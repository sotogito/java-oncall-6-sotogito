package oncall.controller;

import oncall.domain.CalendarManager;
import oncall.domain.MemberManager;
import oncall.domain.WeekdayOnCall;
import oncall.domain.WeekendOnCall;
import oncall.view.InputView;
import oncall.view.OutputView;


public class OnCall {

    public void run() {
        CalendarManager calendarManager = createCalendarManager();
        MemberManager memberManager = createMemberManager();
        OnCallPrinter onCallPrinter = runOnCallPrinter(calendarManager, memberManager);

        onCallPrinter.print();
    }

    private OnCallPrinter runOnCallPrinter(CalendarManager calendarManager, MemberManager memberManager) {
        return new OnCallPrinter(calendarManager, memberManager);
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

    private WeekdayOnCall createWeekdayOnCall() {
        return new WeekdayOnCall(InputView.inputWeekdayMember());
    }

    private WeekendOnCall createWeekendOnCall() {
        return new WeekendOnCall(InputView.inputWeekendMemebr());
    }

}
