package oncall.domain;

public enum WorkType {
    WEEKDAY(false),
    WEEKEND(true);

    private final boolean isWeekend;

    // Enum 생성자
    WorkType(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    // isWeekend 값을 반환하는 메서드
    public boolean isWeekend() {
        return isWeekend;
    }
}
