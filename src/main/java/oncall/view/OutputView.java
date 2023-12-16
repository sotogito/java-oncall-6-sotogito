package oncall.view;

public class OutputView {
    private final static String ON_CALL_LIST_TEMPLATE = "%d월 %d일 %s %s\n";

    public static void printErrorMessage(String error) {
        System.out.print("[ERROR] " + error);
    }

    public static void printOnCallList(int month, int day, String weekday, String member) {
        System.out.printf(ON_CALL_LIST_TEMPLATE, month, day, weekday, member);

    }

}
