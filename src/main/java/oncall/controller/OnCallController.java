package oncall.controller;

import oncall.domain.OnCallScheduler;
import oncall.service.OnCallService;
import oncall.view.ExceptionHandler;
import oncall.view.InputView;

public class OnCallController {
    private final OnCallService onCallService = new OnCallService();

    /**
     * 날짜 받으면 피룡한거
     * - 받는 날짜 : 월, 요일
     * 월
     * 요일 : 주말인지 - DayOdWeekKorean(E)
     * 해당 달이 며칠까지 있는지 - yearMonth.lengthOfMonth();
     * 해달 달의 시작 요일이 맞는지 - LocalDate.of(2023,1,1) ->  onCallDate.getDayOfWeek() -> DayOdWeekKorean
     */
    public void main() {
        OnCallScheduler onCallScheduler = createOnCallScheduler();

    }

    private OnCallScheduler createOnCallScheduler() {
        while (true) {
            try {
                return onCallService.createOnCallScheduler(
                        InputView.readOnCallDate()
                );
            } catch (IllegalArgumentException e) {
                ExceptionHandler.read(e);
            }
        }
    }


}
