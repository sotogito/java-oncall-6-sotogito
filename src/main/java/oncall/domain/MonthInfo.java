package oncall.domain;

public enum MonthInfo {
    JANUARY("1월", "일", 31),
    FEBRUARY("2월", "수", 28),
    MARCH("3월", "수", 31),
    APRIL("4월", "토", 30),
    MAY("5월", "월", 31),
    JUNE("6월", "목", 30),
    JULY("7월", "토", 31),
    AUGUST("8월", "화", 31),
    SEPTEMBER("9월", "금", 30),
    OCTOBER("10월", "일", 31),
    NOVEMBER("11월", "수", 30),
    DECEMBER("12월", "금", 31);

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
