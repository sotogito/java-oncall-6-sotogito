package oncall.domain.manager.member;

import java.util.List;

public class WeekdayOnCallMember {

    private final List<String> weekdayOnCall;

    public WeekdayOnCallMember(List<String> weekdayOnCall) {
        this.weekdayOnCall = weekdayOnCall;
    }

    public List<String> getWeekdayOnCall() {
        return weekdayOnCall;
    }

}
