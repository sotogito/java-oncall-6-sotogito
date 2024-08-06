package oncall.view;

import oncall.domain.schedule.Day;
import oncall.domain.schedule.Days;
import oncall.util.OnCallListFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class OnCallPrinter {

    public static void print(Days days){
        List<String> printout = new ArrayList<>();

        for(Day day : days.getDays()){
            printout.add(OnCallListFormatter.format(day));
        }
        Output.printOnCallList(String.join("\n", printout));
    }
}
