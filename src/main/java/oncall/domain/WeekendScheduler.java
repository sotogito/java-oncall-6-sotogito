package oncall.domain;

import java.util.List;

public class WeekendScheduler implements OnCallMemberMaker{
    private static int index;

    public WeekendScheduler() {
        index = 0;
    }

    @Override
    public String generate(List<String> members) {
        String member = members.get(index % members.size());
        index++;
        return member;
    }
}
