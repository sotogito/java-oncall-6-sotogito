package oncall.domain;

import oncall.util.MemberValidator;

import java.util.List;

public class WeekendOnCall {
    private List<String> weekendOnCall;

    public WeekendOnCall(List<String> weekendOnCall) {
        this.weekendOnCall = weekendOnCall;
    }

    public List<String> getWeekendOnCall(){
        return weekendOnCall;
    }

}
