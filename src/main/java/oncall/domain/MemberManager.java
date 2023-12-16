package oncall.domain;

import oncall.util.MemberValidator;

import java.util.List;

public class MemberManager {
    private final WeekdayOnCall weekdayOnCall;
    private final WeekendOnCall weekendOnCall;

    public MemberManager(WeekdayOnCall weekdayOnCall, WeekendOnCall weekendOnCall) {
        MemberValidator.memberValidate(weekdayOnCall.getWeekdayOnCall());
        MemberValidator.memberValidate(weekendOnCall.getWeekendOnCall());
        MemberValidator.membersValidate(weekdayOnCall.getWeekdayOnCall(), weekdayOnCall.getWeekdayOnCall());
        this.weekdayOnCall = weekdayOnCall;
        this.weekendOnCall = weekendOnCall;

    }

    public List<String> getWeekdayOnCall() {
        return weekdayOnCall.getWeekdayOnCall();
    }

    public List<String> getWeekendOnCall() {
        return weekendOnCall.getWeekendOnCall();
    }

}
