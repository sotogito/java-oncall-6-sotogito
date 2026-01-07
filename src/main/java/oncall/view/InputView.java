package oncall.view;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.OnCallDate;

public class InputView {

    public static OnCallDate readOnCallDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Reader.read().getInput();

        List<String> values = new ArrayList<>();

        String[] splitValues = input.split(",", -1);
        if (splitValues.length != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for (String value : splitValues) {
            values.add(value.trim());
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

}
