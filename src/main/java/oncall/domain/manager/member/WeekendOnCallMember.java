package oncall.domain.manager.member;

import java.util.List;

public class WeekendOnCallMember {
    private final List<String> weekendOnCall;

    public WeekendOnCallMember(List<String> weekendOnCall) {
        this.weekendOnCall = weekendOnCall;
    }

    public List<String> getWeekendOnCall(){
        return weekendOnCall;
    }

}
