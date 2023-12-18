package oncall.domain.manager;

import oncall.domain.manager.member.WeekdayOnCallMember;
import oncall.domain.manager.member.WeekendOnCallMember;
import oncall.util.validator.MemberValidator;

import java.util.List;

public class MemberManager {
    private final WeekdayOnCallMember weekdayOnCall;
    private final WeekendOnCallMember weekendOnCall;

    public MemberManager(WeekdayOnCallMember weekdayOnCall, WeekendOnCallMember weekendOnCall) {
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
