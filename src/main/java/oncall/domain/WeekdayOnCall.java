package oncall.domain;

import oncall.util.MemberValidator;

import java.util.List;

public class WeekdayOnCall {

    private List<String> weekdayOnCall;

    public WeekdayOnCall(List<String> weekdayOnCall) {
        this.weekdayOnCall = weekdayOnCall;
    }

    public List<String> getWeekdayOnCall(){
        return weekdayOnCall;
    }
}
