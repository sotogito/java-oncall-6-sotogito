package oncall.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemberValidator {

    private final static String ERROR_MEMBER = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n";

    public static void memberValidate(List<String> list){
        if(hasDuplicates(list)){
            throw new IllegalArgumentException(ERROR_MEMBER);
        } else if (!isWithinRange(list)) {
            throw new IllegalArgumentException(ERROR_MEMBER);
        }
    }

    public static void membersValidate(List<String> list1, List<String> list2){
        if(!areListsEqual(list1,list2)){
            throw new IllegalArgumentException(ERROR_MEMBER);
        }
    }

    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        return set1.equals(set2);
    }

    private static boolean isWithinRange(List<String> list) {

        return list.size() >= 5 && list.size() <= 35;
    }


    public static boolean hasDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set.size() != list.size();
    }

}
