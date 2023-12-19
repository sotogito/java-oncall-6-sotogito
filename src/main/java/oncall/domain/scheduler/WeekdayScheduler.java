package oncall.domain.scheduler;

import oncall.domain.maker.OnCallMemberMaker;

import java.util.List;

public class WeekdayScheduler implements OnCallMemberMaker {
    private static int index;

    public WeekdayScheduler() {
        index = 0;
    }

    @Override
    public String generate(List<String> members) {
        String member = members.get(index % members.size());
        index++;
        return member;
    }

}
