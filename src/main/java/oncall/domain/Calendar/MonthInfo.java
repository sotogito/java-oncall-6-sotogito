package oncall.domain.Calendar;

import oncall.util.CalengarValidator;

import java.util.ArrayList;
import java.util.List;

public enum MonthInfo {
    JANUARY(1, "일", 31),
    FEBRUARY(2, "수", 28),
    MARCH(3, "수", 31),
    APRIL(4, "토", 30),
    MAY(5, "월", 31),
    JUNE(6, "목", 30),
    JULY(7, "토", 31),
    AUGUST(8, "화", 31),
    SEPTEMBER(9, "금", 30),
    OCTOBER(10, "일", 31),
    NOVEMBER(11, "수", 30),
    DECEMBER(12, "금", 31);

    private final int monthName;
    private final String startDayOfWeek;
    private final int numberOfDays;

    MonthInfo(int monthName, String startDayOfWeek, int numberOfDays) {
        this.monthName = monthName;
        this.startDayOfWeek = startDayOfWeek;
        this.numberOfDays = numberOfDays;
    }

    public int getMonthName() {
        return monthName;
    }

    public String getStartDayOfWeek() {
        return startDayOfWeek;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public static boolean exists(int monthName, String startDayOfWeek) {
        for (MonthInfo monthInfo : MonthInfo.values()) {
            if (monthInfo.getMonthName() == monthName && monthInfo.getStartDayOfWeek().equals(startDayOfWeek)) {
                return true;
            }
        }
        throw new IllegalArgumentException(CalengarValidator.ERROR_EXIST);
    }

    public static int getNumberOfDays(int month) {
        for (MonthInfo monthInfo : MonthInfo.values()) {
            if (monthInfo.getMonthName() == month) {
                return monthInfo.getNumberOfDays();
            }
        }
        throw new IllegalArgumentException();
    }

    public static List<Integer> getDaysOfMonth(int month) {
        int days = getNumberOfDays(month);
        List<Integer> dayList = new ArrayList<>();

        for (int i = 1; i <= days; i++) {
            dayList.add(i);
        }

        return dayList;
    }

}
