package oncall.domain;

import oncall.domain.member.Staff;
import oncall.domain.schedule.Day;
import oncall.domain.schedule.Days;

import java.util.List;

public class OnCallService {
    /**
     * 중복되는지 화인
     *
     */

    private final Staffs WeekdayStaffs;
    private final Staffs WeekendStaffs;
    private final Days days;

    private int weekdayIndex = 0;  // 평일 직원의 인덱스
    private int weekendIndex = 0;  // 주말 직원의 인덱스

    public OnCallService(Days days, Staffs weekdayStaffs, Staffs weekendStaffs) {
        this.days = days;
        WeekdayStaffs = weekdayStaffs;
        WeekendStaffs = weekendStaffs;
    }

    public void onCallMatch(){
        initStaff();

        handleDuplicateStaff();


    }

    public void handleDuplicateStaff(){

        List<Day> dayList = days.getDays();
        boolean hasDuplicates;

        do {
            hasDuplicates = false; // 중복이 없다고 가정

            for (int i = 0; i < dayList.size() - 1; i++) {
                Day firstDay = dayList.get(i);
                Day secondDay = dayList.get(i + 1);

                // 현재 두 날의 직원이 동일하면
                if (firstDay.getStaff() != null && firstDay.getStaff().equals(secondDay.getStaff())) {
                    // 다음 날의 직원을 현재 날과 교환
                    if (i + 2 < dayList.size()) {
                        Day thirdDay = dayList.get(i + 2);
                        secondDay.setStaff(thirdDay.getStaff());
                        thirdDay.setStaff(firstDay.getStaff());
                    } else {
                        // 마지막 날이거나 배열의 범위를 넘어서는 경우
                        secondDay.setStaff(null); // 예를 들어, 마지막 날의 경우 아무도 배치하지 않도록 할 수 있음
                    }
                    hasDuplicates = true; // 중복을 해결했으므로 다시 체크해야 함
                    break; // 현재 루프를 종료하고 중복이 해결된 것을 확인
                }
            }

        } while (hasDuplicates); // 중복이 없을 때까지 계속 반복

        /*
        List<Day> dayList = days.getDays();

        for(int i = 0; i < dayList.size()-1; i++){
            Day firstDay = dayList.get(i);
            Day secondDay = dayList.get(i+1);

            if(firstDay.getStaff().equals(secondDay.getStaff())){
                Day third = dayList.get(i+1);

                secondDay.setStaff(third.getStaff());
                third.setStaff(secondDay.getStaff());
            }
        }

         */
    }

    public void initStaff(){
        List<Staff> weekdayStaffs = WeekdayStaffs.getStaffs();
        List<Staff> WeekendDayStaffs = WeekendStaffs.getStaffs();

        for (Day day : days.getDays()) {
            if (day.isWeekend() || day.isHoliday()) {
                day.setStaff(WeekendDayStaffs.get(weekendIndex));
                weekendIndex = (weekendIndex + 1) % WeekendDayStaffs.size();
                continue;
            }
            day.setStaff(weekdayStaffs.get(weekdayIndex));
            weekdayIndex = (weekdayIndex + 1) % weekdayStaffs.size();
        }

    }
}
