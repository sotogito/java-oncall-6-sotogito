package oncall.domain;

import java.util.List;

public class MemberManager {
    private WeekdayOnCall weekdayOnCall;
    private WeekendOnCall weekendOnCall;


    public MemberManager(WeekdayOnCall weekdayOnCall, WeekendOnCall weekendOnCall) {
        //동일한 사이즈?
        //동일한 멤버?
        this.weekdayOnCall = weekdayOnCall;
        this.weekendOnCall =weekendOnCall;

    }

}
