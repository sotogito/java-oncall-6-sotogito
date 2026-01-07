package oncall.service;

import oncall.domain.OnCallDate;
import oncall.domain.OnCallScheduler;

public class OnCallService {

    public OnCallScheduler createOnCallScheduler(OnCallDate onCallDate) {
        return OnCallScheduler.create(
                onCallDate.month(),
                onCallDate.dayOfWeek()
        );
    }

}
