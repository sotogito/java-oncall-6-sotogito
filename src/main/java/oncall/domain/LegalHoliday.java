package oncall.domain;

import java.time.LocalDate;

public enum LegalHoliday {
    신(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25);

    private final int month;
    private final int day;

    LegalHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isLegalHoliday(LocalDate localDate) {
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        for (LegalHoliday legalHoliday : LegalHoliday.values()) {
            int legalMonth = legalHoliday.month;
            ;
            int legalDay = legalHoliday.day;

            if (month == legalMonth && day == legalDay) {
                return true;
            }
        }

        return false;
    }

}
