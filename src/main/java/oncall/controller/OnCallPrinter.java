package oncall.controller;

import oncall.domain.scheduler.OnCallDayEntry;
import oncall.domain.scheduler.OnCallScheduler;
import oncall.view.OutputView;


public class OnCallPrinter {

    public static void runPrinter(OnCallScheduler onCallScheduler) {
        for (OnCallDayEntry eachDay : onCallScheduler.getOnCallList()) {
            int month = eachDay.getMonth();
            int day = eachDay.getDay();
            String dayOfWeek = eachDay.getDayOfWeek();
            String member = eachDay.getMember();

            OutputView.printOnCallList(month, day, dayOfWeek, member);
        }
    }

}
