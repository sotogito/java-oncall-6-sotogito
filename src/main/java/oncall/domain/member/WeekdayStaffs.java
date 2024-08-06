package oncall.domain.member;

import oncall.domain.WorkType;
import oncall.domain.Staffs;

import java.util.ArrayList;
import java.util.List;

public class WeekdayStaffs implements Staffs {
    private List<Staff> staffs = new ArrayList<>();

    public WeekdayStaffs() {

    }

    public WorkType getWorkType() {
        return WorkType.WEEKDAY;
    }

    public boolean isWeekend(){
        return getWorkType().isWeekend();
    }

}
