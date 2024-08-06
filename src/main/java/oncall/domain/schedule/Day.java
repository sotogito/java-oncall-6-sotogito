package oncall.domain.schedule;

import oncall.domain.member.Staff;

public class Day {
    private int month;
    private int day;
    private String dayOfWeek;

    private boolean isWeekend = false;
    private boolean isHoliday = false;

    private Staff staff;

    public Day(int month, int day , String dayOfWeek, boolean isWeekend, boolean isHoliday) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isWeekend = isWeekend;
        this.isHoliday = isHoliday;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getMonth() {
        return month;
    }

    public int getDay(){
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Staff getStaff() {
        return staff;
    }

    public boolean isWeekend(){
        return isWeekend;
    }

    public boolean isHoliday(){
        return isHoliday;
    }

    public boolean isAddHolidayMark(){
        return !isWeekend && isHoliday; //note 주말이아니면서 + 공휴일
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(month);
        result.append("+");
        result.append(day);
        result.append("+");
        result.append(dayOfWeek);
        result.append("+");
        result.append(isWeekend);
        result.append("+");
        result.append(isHoliday);
        return result.toString();
    }

}
