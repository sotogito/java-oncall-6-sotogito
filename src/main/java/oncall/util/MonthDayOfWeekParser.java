package oncall.util;

import java.util.ArrayList;
import java.util.List;

public class MonthDayOfWeekParser {

    public static List<String> parse(String input) {
        String[] parts = input.split(",");

        // 결과를 저장할 리스트
        List<String> result = new ArrayList<>();

        // 각 부분을 트림하고 리스트에 추가
        for (String part : parts) {
            result.add(part.trim());
        }

        try{
            Integer.parseInt(parts[0]);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("month는 숫자로 입력해주세요");
        }

        return result;
    }
}
