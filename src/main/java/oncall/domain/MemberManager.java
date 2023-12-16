package oncall.domain;

import java.util.List;

public class MemberManager {
    private WeekdayOnCall weekdayOnCall;
    private WeekendOnCall weekendOnCall;


    public MemberManager(List<String> weekday, List<String> weekend) {
        //동일한 사이즈?
        //동일한 멤버?
        weekdayOnCall = new WeekdayOnCall(weekday);
        weekendOnCall = new WeekendOnCall(weekend);

    }

}
