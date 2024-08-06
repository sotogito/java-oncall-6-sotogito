package oncall.domain.member;

import java.util.Objects;

public class Staff {
    private final String name;

    public Staff(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("1~5자의 닉네임을 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff car = (Staff) o;
        return Objects.equals(name, car.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
