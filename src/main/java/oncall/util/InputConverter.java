package oncall.util;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    public static List<String> convertStringToList(String input) {
        String[] items = input.split(",");
        return Arrays.asList(items);
    }
}
