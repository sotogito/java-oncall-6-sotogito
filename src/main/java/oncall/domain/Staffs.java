package oncall.domain;

import oncall.domain.member.Staff;

import java.util.List;

public interface Staffs {
    int getNumberOfStaff();

    List<Staff> getStaffs();
}
