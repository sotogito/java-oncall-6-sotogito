package oncall.domain.member;

import oncall.domain.WorkType;
import oncall.domain.Staffs;

import java.util.ArrayList;
import java.util.List;

public class WeekendStaffs implements Staffs {
    private List<Staff> staffs = new ArrayList<>();

    public WeekendStaffs() {

    }



    public WorkType getWorkType() {
        return WorkType.WEEKEND;
    }

    public boolean isWeekend(){
        return getWorkType().isWeekend();
    }
}
