package oncall.util;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    private final static String DIVIDER = ",";

    public static List<String> convertStringToList(String input) {
        String[] items = input.split(DIVIDER);
        return Arrays.asList(items);
    }

}
