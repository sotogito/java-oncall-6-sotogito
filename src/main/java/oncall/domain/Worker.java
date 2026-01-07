package oncall.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Worker implements Comparable<Worker> {
    private String nickname;
    private LocalDate workDate;
    private final WorkType workType;

    public Worker(String nickname, WorkType workType) {
        validateNickname(nickname);

        this.nickname = nickname;
        this.workType = workType;
    }

    public Worker(String nickname, LocalDate workTime, WorkType workType) {
        this.nickname = nickname;
        this.workDate = workTime;
        this.workType = workType;
    }

    public DayOfWeekKorean getDayOfWeek() {
        return DayOfWeekKorean.find(workDate.getDayOfWeek());
    }

    private void validateNickname(String nickname) {
        if (nickname.isEmpty() || nickname.length() > 5) {
            throw new IllegalArgumentException("사원 닉네임은 최대 5자까지 가능합니다.");
        }
    }

    public void change(Worker other) {
        String otherName = other.nickname;
        String thisName = this.nickname;

        this.nickname = otherName;
        other.nickname = thisName;
    }

    public Worker newWorker(LocalDate workDate, WorkType workType) {
        return new Worker(
                this.nickname,
                workDate,
                workType
        );
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
        return this.workDate.compareTo(o.workDate);
    }

    @Override
    public String toString() {
        int month = workDate.getMonthValue();
        int day = workDate.getDayOfMonth();
        String dayOfWeek = getDayOfWeek().getKorean();

        if (workType == WorkType.HOLIDAY) {
            return String.format("%d월 %d일 %s(휴일) %s", month, day, dayOfWeek, nickname);
        }
        return String.format("%d월 %d일 %s %s", month, day, dayOfWeek, nickname);
    }

}
