package oncall.service;

import java.util.List;
import oncall.domain.OnCallScheduler;
import oncall.domain.Worker;
import oncall.domain.Workers;

public class OnCallService {

    public List<Worker> schedule(OnCallScheduler onCallScheduler, Workers workers) {
        return onCallScheduler.schedule(workers);
    }


}
