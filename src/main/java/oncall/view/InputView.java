package oncall.view;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.OnCallDate;

public class InputView {

    public static OnCallDate readOnCallDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");

        List<String> values = parse(Reader.read());
        if (values.size() != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        int month;
        String dayOfWeek = values.get(1);
        try {
            month = Integer.parseInt(values.get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return new OnCallDate(month, dayOfWeek);
    }

    public static List<String> readWeekdayWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

        return parse(Reader.read());
    }

    public static List<String> readWeekendWorkers() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

        return parse(Reader.read());
    }


    private static List<String> parse(Reader reader) {
        List<String> values = new ArrayList<>();

        String[] splitValues = reader.getInput().split(",");
        for (String value : splitValues) {
            values.add(value.trim());
        }
        return values;
    }

}
