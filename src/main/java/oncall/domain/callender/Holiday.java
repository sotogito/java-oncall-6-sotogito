package oncall.domain.callender;

public enum Holiday {
    NEW_YEAR("신정", 1, 1),
    INDEPENDENCE_MOVEMENT_DAY("삼일절", 3, 1),
    CHILDRENS_DAY("어린이날", 5, 5),
    MEMORIAL_DAY("현충일", 6, 6),
    LIBERATION_DAY("광복절", 8, 15),
    NATIONAL_FOUNDATION_DAY("개천절", 10, 3),
    HANGEUL_DAY("한글날", 10, 9),
    CHRISTMAS("성탄절", 12, 25);

    private final String name;
    private final int month;
    private final int day;

    Holiday(String name, int month, int day) {
        this.name = name;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }



}
