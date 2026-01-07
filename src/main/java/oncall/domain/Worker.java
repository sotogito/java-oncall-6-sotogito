package oncall.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Worker implements Comparable<Worker> {
    private final String nickname;
    private LocalDate workTime;
    private final WorkType workType;

    public Worker(String nickname, WorkType workType) {
        validateNickname(nickname);

        this.nickname = nickname;
        this.workType = workType;
    }

    public Worker(String nickname, LocalDate workTime, WorkType workType) {
        this.nickname = nickname;
        this.workTime = workTime;
        this.workType = workType;
    }

    private void validateNickname(String nickname) {
        if (nickname.isEmpty() || nickname.length() > 5) {
            throw new IllegalArgumentException("사원 닉네임은 최대 5자까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(nickname, worker.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public int compareTo(Worker o) {
        return this.workTime.compareTo(o.workTime);
    }

    @Override
    public String toString() {
        return nickname + workType.toString();
    }

}
