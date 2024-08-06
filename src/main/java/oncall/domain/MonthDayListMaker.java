package oncall.domain;

import oncall.domain.callender.Holiday;
import oncall.domain.callender.MonthDays;
import oncall.domain.callender.WeekDay;
import oncall.domain.schedule.Day;

import java.util.ArrayList;
import java.util.List;

public class MonthDayListMaker {
    /**
     * day에 month추가하기
     * MonthDays에서 개수 받아서 for 돌려서 ㅇ묘 업데이트하기
     * Weekday받아서 업데이트
     *
     *
     */

    public static List<Day> makeMothList(int monthDay, String startDayOfWeek){
        List<Day> result = new ArrayList<>();

        int numberOfDays = MonthDays.findNumberOfDaysByMonth(monthDay);
        List<WeekDay> weekDayList = WeekDay.getWeekDay(startDayOfWeek);

        for (int i = 1; i < numberOfDays+1; i++) {
            int month = monthDay;
            int day = i;
            WeekDay dayOfWeekType = weekDayList.get((i - 1) % weekDayList.size());
            String dayOfWeek = dayOfWeekType.getKoreanName();
            boolean isWeekend = dayOfWeekType.isWeekend();
            boolean isHoliday = Holiday.isHoliday(month, day);

            result.add(new Day(month,day,dayOfWeek,isWeekend,isHoliday));
        }
        return result;
    }
}
