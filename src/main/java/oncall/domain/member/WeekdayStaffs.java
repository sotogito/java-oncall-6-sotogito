package oncall.domain.member;

import oncall.domain.WorkType;
import oncall.domain.Staffs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeekdayStaffs implements Staffs {
    private List<Staff> staffs = new ArrayList<>();

    public WeekdayStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public Optional<Staff> getStaffByName(String name) {
        for (Staff staff : staffs) {
            if (staff.getName().equals(name)) {
                return Optional.of(staff);
            }
        }
        return Optional.empty();
    }

    public WorkType getWorkType() {
        return WorkType.WEEKDAY;
    }

    public int getNumberOfStaff(){
        return staffs.size();
    }

    public boolean isWeekend(){
        return getWorkType().isWeekend();
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
