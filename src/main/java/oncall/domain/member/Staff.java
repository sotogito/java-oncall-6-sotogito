package oncall.domain.member;

public class Staff {
    private final String name;

    public Staff(String name) {
        //todo 이름 유효검사
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
