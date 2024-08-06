package oncall.domain.member;

import oncall.domain.WorkType;
import oncall.domain.Staffs;

import java.util.ArrayList;
import java.util.List;

public class WeekendStaffs implements Staffs {
    private List<Staff> staffs = new ArrayList<>();

    public WeekendStaffs(List<Staff> staffs) {
        this.staffs = staffs;

    }

    public List<Staff> getStaffs() {
        return staffs;
    }


    public WorkType getWorkType() {
        return WorkType.WEEKEND;
    }

    public boolean isWeekend(){
        return getWorkType().isWeekend();
    }
    public int getNumberOfStaff(){
        return staffs.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Staff staff : staffs) {
            builder.append(staff.toString()).append("\n");
        }
        return builder.toString();
    }

}
