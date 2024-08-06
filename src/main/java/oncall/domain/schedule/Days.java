package oncall.domain.schedule;

import oncall.domain.MonthDayListMaker;
import oncall.util.MonthDayOfWeekParser;

import java.util.ArrayList;
import java.util.List;

public class Days {
    private List<Day> days = new ArrayList<>();

    /**
     * 스테프 배치는 아직 이뤄지지 않음
     * @param month
     * @param startDayOfWeek
     */
    public Days(int month, String startDayOfWeek) {
        this.days = MonthDayListMaker.makeMothList(month, startDayOfWeek);
    }

    public List<Day> getDays() {
        return days;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Day day : days) {
            result.append(day.toString()).append("\n");
        }
        return result.toString();
    }
}
