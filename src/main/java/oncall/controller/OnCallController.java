package oncall.controller;

import oncall.domain.Calendar.Month;
import oncall.domain.Calendar.PublicHoliday;
import oncall.domain.Calendar.Week;
import oncall.domain.OnCallDayEntry;
import oncall.domain.OnCallScheduler;
import oncall.domain.manager.CalendarManager;
import oncall.domain.manager.MemberManager;
import oncall.domain.manager.member.WeekdayOnCallMember;
import oncall.domain.manager.member.WeekendOnCallMember;
import oncall.util.OnCallDayMaker;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class OnCallController {

    int weekdayIndex = 0;
    int weekendIndex = 0;

    public void run() {
        CalendarManager calendarManager = createCalendarManager();
        MemberManager memberManager = createMemberManager();

        OnCallScheduler onCallScheduler = createOnCallScheduler(calendarManager,memberManager);

        for(OnCallDayEntry data : onCallScheduler.getOnCallList()){
            System.out.println(data.getMonth()+"월 "+data.getDay()+"일 "+data.getDayOfWeek()+" "+data.getMember());
        }


    }

    private OnCallScheduler createOnCallScheduler(CalendarManager calendarManager,MemberManager memberManager){
        List<OnCallDayEntry> result = new ArrayList<>();


        int dayCount = Month.getNumberOfDays(calendarManager.getMonth());
        List<Week> weekList = Week.getOrderedDaysStartingFrom(calendarManager.getDay());

        for(int i=1; i<=dayCount; i++){
            Week dayOfWeek = weekList.get((i-1) % weekList.size());
            result.add(createOnCallDayEntry(calendarManager.getMonth(),i,dayOfWeek,memberManager));
        }
        return new OnCallScheduler(result);
    }

    private OnCallDayEntry createOnCallDayEntry(int month, int day,Week dayOfWeek,MemberManager memberManager){
        int monthData = month; //월
        int dayData = day; //일
        String dayOfWeekData = dayOfWeek.day(); //요일
        String memberData = "";

        boolean isHoliday = PublicHoliday.isHoliday(monthData,dayData);

        if(!dayOfWeek.isWeekEnd() && !isHoliday){ //+(휴일)
            List<String> dayMember = memberManager.getWeekdayOnCall();
            memberData = dayMember.get(weekdayIndex % dayMember.size());
            weekdayIndex++;


        }else if(dayOfWeek.isWeekEnd()){
            List<String> endMember = memberManager.getWeekendOnCall();
            memberData = endMember.get(weekendIndex % endMember.size());
            weekendIndex++;
        }
        if(!dayOfWeek.isWeekEnd() && isHoliday){
            List<String> endMember = memberManager.getWeekendOnCall();
            memberData = endMember.get(weekendIndex % endMember.size());
            weekendIndex++;
            dayOfWeekData += "(휴일)";
        }


        return new OnCallDayEntry(monthData,dayData,dayOfWeekData,memberData);
    }





    private CalendarManager createCalendarManager() {
        try {
            return new CalendarManager(InputView.inputMonthDay());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createCalendarManager();
        }
    }

    private MemberManager createMemberManager() {
        try {
            return new MemberManager(createWeekdayOnCall(), createWeekendOnCall());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createMemberManager();
        }

    }

    private WeekdayOnCallMember createWeekdayOnCall() {
        return new WeekdayOnCallMember(InputView.inputWeekdayMember());
    }

    private WeekendOnCallMember createWeekendOnCall() {
        return new WeekendOnCallMember(InputView.inputWeekendMemebr());
    }




}
