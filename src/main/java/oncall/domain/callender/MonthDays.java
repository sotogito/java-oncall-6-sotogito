package oncall.domain.callender;

public enum MonthDays {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int month;
    private final int days;

    MonthDays(int month, int days) {
        this.month = month;
        this.days = days;
    }

    public int getMonth() {
        return month;
    }

    public int getDays() {
        return days;
    }

    public static int findNumberOfDaysByMonth(int month) {
        for (MonthDays day : MonthDays.values()) {
            if (day.getMonth() == month) {
                return day.getDays();
            }
        }
        throw new IllegalArgumentException("존재하지 않는  month입니다.");
    }



}
