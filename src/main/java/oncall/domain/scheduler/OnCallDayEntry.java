package oncall.domain.scheduler;

public class OnCallDayEntry { //온콜 리스크의 '하루' 데이터를 담는다
    private int month;
    private int day;
    private String dayOfWeek;
    private String member;
    private boolean isWeekend;

    public OnCallDayEntry(int month, int day, String dayOfWeek,String member,boolean isWeekend) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.member = member;
        this.isWeekend = isWeekend;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String getDayOfWeek(){
        return dayOfWeek;
    }
    public String getMember(){
        return member;
    }

    public boolean getIsWeekend(){
        return isWeekend;
    }

    public void setMember(String member) {
        this.member = member;
    }


}
