package oncall.controller;

import java.util.List;
import oncall.domain.OnCallDate;
import oncall.domain.OnCallScheduler;
import oncall.domain.WorkType;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.service.OnCallService;
import oncall.view.ExceptionHandler;
import oncall.view.InputView;

public class OnCallController {
    private final OnCallService onCallService = new OnCallService();

    public void main() {
        OnCallScheduler onCallScheduler = createOnCallScheduler();
        Workers workers = createWorkers();

        List<Worker> onCallResult = onCallService.schedule(onCallScheduler,workers);

        for(Worker worker : onCallResult) {
            System.out.println(worker);
        }


    }

    private Workers createWorkers() {
        while (true) {
            try {
                List<Worker> weekdayWorkers = InputView.readWeekdayWorkers().stream()
                        .map(workerNickname -> new Worker(workerNickname, WorkType.WEEKDAY))
                        .toList();
                List<Worker> weekendWorkers = InputView.readWeekendWorkers().stream()
                        .map(workerNickname -> new Worker(workerNickname, WorkType.WEEKEND))
                        .toList();

                return Workers.createWeekdayWeekendWorkers(weekdayWorkers, weekendWorkers);
            } catch (IllegalArgumentException e) {
                ExceptionHandler.read(e);
            }
        }
    }

    private OnCallScheduler createOnCallScheduler() {
        while (true) {
            try {
                OnCallDate onCallDate = InputView.readOnCallDate();

                return OnCallScheduler.create(
                        onCallDate.month(),
                        onCallDate.dayOfWeek()
                );
            } catch (IllegalArgumentException e) {
                ExceptionHandler.read(e);
            }
        }
    }

}
