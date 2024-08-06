package oncall.util.staff;

import oncall.domain.Staffs;
import oncall.domain.member.Staff;
import oncall.domain.member.WeekdayStaffs;

import java.util.*;

/**
 * 인원이 5명~35명인지 학인은 어디에서 하지
 * 같은 인원이들어와야하나ㅣ까ㅓ 주말의 인원이 평일의 인원과 같은지 찾기
 *
 * 1. 중복
 * 2. 인원수
 */
public class StaffParser {

    /**
     * 이름, 중복
     */
    public static List<Staff> getWeekdayStaffList(String input){
        List<Staff> result = new ArrayList<>();

        String[] splitWord = input.split(",");
        for (String s : splitWord) {
            result.add(new Staff(s.trim()));
        }
        hasDuplicates(result);
        return result;
    }

    public static List<Staff> getWeekendStaffList(String input, WeekdayStaffs weekdayStaffs){
        List<Staff> result = new ArrayList<>();

        String[] splitWord = input.split(",");
        for (String s : splitWord) {
            Optional<Staff> newStaff = weekdayStaffs.getStaffByName(s.trim());
            if(newStaff.isEmpty()){
                throw new IllegalArgumentException("주말과, 평일 멤버가 달라요.");
            }
            result.add(newStaff.get());
        }

        if(result.size() <5 || result.size() > 35){
            throw new IllegalArgumentException("인원은 총 5~35까지 가능합니다.");
        }


        return result;
    }




    private static void hasDuplicates(List<Staff> staff) {
        Set<Staff> carSet = new HashSet<>();
        for (Staff car : staff) {
            if (!carSet.add(car)) {
                throw new IllegalArgumentException("중복된 닉네임이 있어요.");
            }
        }
    }


}
