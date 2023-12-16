package oncall.domain;

public enum MonthInfo {
    JANUARY("1월", "월요일", 31),
    FEBRUARY("2월", "수요일", 28),
    MARCH("3월", "월요일", 31),
    APRIL("4월", "목요일", 30),
    MAY("5월", "토요일", 31),
    JUNE("6월", "화요일", 30),
    JULY("7월", "목요일", 31),
    AUGUST("8월", "일요일", 31),
    SEPTEMBER("9월", "수요일", 30),
    OCTOBER("10월", "금요일", 31),
    NOVEMBER("11월", "월요일", 30),
    DECEMBER("12월", "수요일", 31);

    private final String monthName;
    private final String startDayOfWeek;
    private final int numberOfDays;

    MonthInfo(String monthName, String startDayOfWeek, int numberOfDays) {
        this.monthName = monthName;
        this.startDayOfWeek = startDayOfWeek;
        this.numberOfDays = numberOfDays;
    }

    public String getMonthName() {
        return monthName;
    }

    public String getStartDayOfWeek() {
        return startDayOfWeek;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

}
