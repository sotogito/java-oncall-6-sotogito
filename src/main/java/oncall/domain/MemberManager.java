package oncall.domain;

import oncall.util.MemberValidator;

import java.util.List;

public class MemberManager {
    private WeekdayOnCall weekdayOnCall;
    private WeekendOnCall weekendOnCall;


    public MemberManager(WeekdayOnCall weekdayOnCall, WeekendOnCall weekendOnCall) {
        //동일한 사이즈?
        //동일한 멤버?
        MemberValidator.memberValidate(weekdayOnCall.getWeekdayOnCall());
        MemberValidator.memberValidate(weekendOnCall.getWeekendOnCall());
        MemberValidator.membersValidate(weekdayOnCall.getWeekdayOnCall(),weekdayOnCall.getWeekdayOnCall());
        this.weekdayOnCall = weekdayOnCall;
        this.weekendOnCall =weekendOnCall;

    }

    public List<String> getWeekdayOnCall(){
        return weekdayOnCall.getWeekdayOnCall();
    }

    public List<String> getWeekendOnCall(){
        return weekendOnCall.getWeekendOnCall();
    }

}
