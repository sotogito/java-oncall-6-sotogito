package oncall.domain;

import java.util.List;

public class OnCallScheduler {

    private List<OnCallDayEntry> onCallList;

    public OnCallScheduler(List<OnCallDayEntry> onCallList) {
        this.onCallList = onCallList;
    }
}
