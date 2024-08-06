package oncall.controller;

import oncall.domain.OnCallService;
import oncall.domain.Staffs;
import oncall.domain.member.Staff;
import oncall.domain.member.WeekdayStaffs;
import oncall.domain.member.WeekendStaffs;
import oncall.domain.schedule.Day;
import oncall.domain.schedule.Days;
import oncall.util.MonthDayOfWeekParser;
import oncall.util.OnCallListFormatter;
import oncall.util.staff.StaffParser;
import oncall.view.Input;
import oncall.view.OnCallPrinter;
import oncall.view.Output;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    public void main() {

        Days days = createDays();


        List<Staffs> staffs = createStaffs();
        Staffs weekdayStaffs = staffs.get(0);
        Staffs weekendStaffs = staffs.get(1);



        OnCallService onCallService = createOnCallService(days, weekdayStaffs, weekendStaffs);

        onCallService.onCallMatch();


        OnCallPrinter.print(days);


        /*
        for(Day day : days.getDays()) {
            System.out.println(OnCallListFormatter.format(day));
        }

         */

    }


    public OnCallService createOnCallService(Days days, Staffs weekdayStaffs, Staffs weekendStaffs) {
        return new OnCallService(days, weekdayStaffs, weekendStaffs);
    }

    public Days createDays(){
        while (true){
            try{
                List<String> monthAndStartDayOfWeek = MonthDayOfWeekParser.parse(Input.inputMonthAndStartDayOfWeek());
                int month = Integer.parseInt(monthAndStartDayOfWeek.get(0));
                String dayOfWeek = monthAndStartDayOfWeek.get(1);
                return new Days(month,dayOfWeek);
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    public List<Staffs> createStaffs(){
        while (true){
            try{
                List<Staffs> staffs = new ArrayList<>(2);

                WeekdayStaffs weekdayStaffs = createWeekdayStaffs();
                staffs.add(weekdayStaffs);

                WeekendStaffs weekendStaffs = createWeekendStaffs(weekdayStaffs);
                staffs.add(weekendStaffs);

                return staffs;
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    public WeekdayStaffs createWeekdayStaffs() {
        List<Staff> weekdayStaffs = StaffParser.getWeekdayStaffList(Input.inputWeekdayStaffsName());
        return new WeekdayStaffs(weekdayStaffs);
    }

    public WeekendStaffs createWeekendStaffs(WeekdayStaffs weekdayStaffs) {
        List<Staff> weekendStaffs = StaffParser.getWeekendStaffList(Input.inputWeekendStaffsName(), weekdayStaffs);
        return new WeekendStaffs(weekendStaffs);

    }


}
