package oncall.controller;

import oncall.domain.Calendar.Week;
import oncall.domain.Calendar.Month;
import oncall.domain.Calendar.PublicHoliday;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;
import oncall.domain.scheduler.OnCallDayEntry;
import oncall.domain.scheduler.OnCallScheduler;
import oncall.view.OutputView;

import java.util.List;

public class OnCallPrinter {

    public static void runPrinter(OnCallScheduler onCallScheduler) {
        for(OnCallDayEntry eachDay : onCallScheduler.getOnCallList()){
            int month = eachDay.getMonth();
            int day = eachDay.getDay();
            String dayOfWeek = eachDay.getDayOfWeek();
            String member = eachDay.getMember();

            OutputView.printOnCallList(month,day,dayOfWeek,member);
        }
    }
}
