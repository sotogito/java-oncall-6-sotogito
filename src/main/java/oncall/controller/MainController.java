package oncall.controller;

import oncall.domain.Staffs;
import oncall.domain.member.Staff;
import oncall.domain.member.WeekdayStaffs;
import oncall.domain.member.WeekendStaffs;
import oncall.util.OnCallListFormatter;
import oncall.util.staff.StaffParser;
import oncall.view.Input;
import oncall.view.Output;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    public void main() {
        List<Staffs> staffs = createStaffs();
        Staffs weekdayStaffs = staffs.get(0);
        Staffs weekendStaffs = staffs.get(1);
        /*
        while (true) {
            try {
                weekdayStaffs = createWeekdayStaffs();
                weekendStaffs = createWeekendStaffs(weekdayStaffs);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }

         */

        System.out.println(weekdayStaffs);
        System.out.println(weekendStaffs);

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
        List<Staff> weekdayStaffs = StaffParser.getWeekdayStaffList(Input.inputStaffsName());
        return new WeekdayStaffs(weekdayStaffs);
    }

    public WeekendStaffs createWeekendStaffs(WeekdayStaffs weekdayStaffs) {
        List<Staff> weekendStaffs = StaffParser.getWeekendStaffList(Input.inputStaffsName(), weekdayStaffs);
        return new WeekendStaffs(weekendStaffs);

    }


}
