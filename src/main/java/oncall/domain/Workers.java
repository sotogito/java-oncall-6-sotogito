package oncall.domain;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Workers {
    private final EnumMap<WorkType, List<Worker>> workers;

    public Workers(EnumMap<WorkType, List<Worker>> workers) {
        this.workers = workers;
    }

    public static Workers createWeekdayWeekendWorkers(List<Worker> weekday, List<Worker> weekend) {
        validateDuplicate(weekday);
        validateDuplicate(weekend);
        validateMaxCount(weekday, weekend);

        EnumMap<WorkType, List<Worker>> workers = new EnumMap<>(WorkType.class);
        workers.put(WorkType.WEEKDAY, weekday);
        workers.put(WorkType.WEEKEND, weekend);

        return new Workers(workers);
    }


    public List<Worker> getWorkersByWorkType(WorkType workType) {
        if (workers.containsKey(workType)) {
            return workers.get(workType);
        }
        return List.of();
    }

    public static void validateDuplicate(List<Worker> staffs) {
        if (staffs.size() != new HashSet<>(staffs).size()) {
            throw new IllegalArgumentException("중복된 사원 이름이 있습니다.");
        }
    }

    public static void validateMaxCount(List<Worker> weekday, List<Worker> weekend) {
        Set<Worker> uniqueWorkers = new HashSet<>();

        uniqueWorkers.addAll(weekday);
        uniqueWorkers.addAll(weekend);

        int totalCount = uniqueWorkers.size();
        if (totalCount > 35) {
            throw new IllegalArgumentException("총 인원은 35명까지 등록 가능합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (WorkType workType : WorkType.values()) {
            sb.append(workType.toString());

            if (workers.containsKey(workType)) {
                for (Worker worker : workers.get(workType)) {
                    sb.append(worker.toString()).append("\n");
                }
            }
        }
        return sb.toString();
    }

}
