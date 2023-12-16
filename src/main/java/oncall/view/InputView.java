package oncall.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import oncall.util.InputConverter;

public class InputView {

    private final static String INPUT_MONTH_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private final static String INPUT_WEEK_DAY= "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private final static String INPUT_WEEK_END= "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";


    public static List<String> inputMonthDay(){
        System.out.print(INPUT_MONTH_DAY);
        return InputConverter.convertStringToList(Console.readLine());
    }

    public static List<String> inputWeekdayMember(){
        System.out.print(INPUT_WEEK_DAY);
        return InputConverter.convertStringToList(Console.readLine());

    }
    public static List<String> inputWeekendMemebr(){
        System.out.print(INPUT_WEEK_END);
        return InputConverter.convertStringToList(Console.readLine());

    }

}
