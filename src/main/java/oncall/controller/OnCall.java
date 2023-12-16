package oncall.controller;

import oncall.domain.CalendarManager;
import oncall.domain.MemberManager;
import oncall.domain.WeekdayOnCall;
import oncall.domain.WeekendOnCall;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCall {

    public void run(){
        MemberManager memberManager = createMemberManager();

    }

    private CalendarManager createCalendarManager(){
        try{

        }
    }



    private MemberManager createMemberManager(){
        try{
            return new MemberManager(createWeekdayOnCall(),createWeekendOnCall());
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            return createMemberManager();
        }

    }

    private WeekdayOnCall createWeekdayOnCall(){
        return new WeekdayOnCall(InputView.inputWeekdayMember());
    }

    private WeekendOnCall createWeekendOnCall(){
        return new WeekendOnCall(InputView.inputWeekendMemebr());
    }
}
