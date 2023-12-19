package oncall.domain.scheduler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OnCallScheduler {

    private List<OnCallDayEntry> onCallList;

    public OnCallScheduler(List<OnCallDayEntry> onCallList) {
        this.onCallList = onCallList;
        while (!isDuplicateMember()){
            removeDuplicates();
        }
    }

    public List<OnCallDayEntry> getOnCallList() {
        return onCallList;
    }

    private boolean isDuplicateMember() {
        for(int i = 0; i<onCallList.size()-1; i++){
            String prev = onCallList.get(i).getMember();
            String current = onCallList.get(i+1).getMember();

            if(prev.equals(current)){
                return false;
            }
        }
        return true;
    }

    private void removeDuplicates() {
        for(int i = 0; i<onCallList.size()-2; i++){
            OnCallDayEntry prev = onCallList.get(i);
            OnCallDayEntry current = onCallList.get(i+1);
            OnCallDayEntry next = onCallList.get(i+2);

            if(prev.getMember().equals(current.getMember())){
                System.out.println(prev.getMember());
                System.out.println(current.getMember());
                switchingMember(current,next);
            }
        }
    }

    private void switchingMember(OnCallDayEntry current,OnCallDayEntry next){
        String currentMemberSave = current.getMember();

        current.setMember(next.getMember());
        next.setMember(currentMemberSave);
    }

}
