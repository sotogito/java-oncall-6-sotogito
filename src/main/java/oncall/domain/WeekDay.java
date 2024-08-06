package oncall.domain;

public enum WeekDay {
    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true),
    SUNDAY("일", true);

    private final String koreanName;
    private final boolean isWeekend;

    WeekDay(String koreanName, boolean isWeekend) {
        this.koreanName = koreanName;
        this.isWeekend = isWeekend;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    @Override
    public String toString() {
        return koreanName + (isWeekend ? " (주말)" : " (평일)");
    }

}
