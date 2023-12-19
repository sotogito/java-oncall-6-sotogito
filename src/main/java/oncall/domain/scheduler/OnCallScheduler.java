package oncall.domain.scheduler;

import java.util.List;

public class OnCallScheduler {

    private List<OnCallDayEntry> onCallList;

    public OnCallScheduler(List<OnCallDayEntry> onCallList) {
        //중복되는 사람이 없을 때까지 배열.
        this.onCallList = onCallList;
    }

    public List<OnCallDayEntry> getOnCallList(){
        return onCallList;
    }


}
