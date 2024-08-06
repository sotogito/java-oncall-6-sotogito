package oncall;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest2 extends NsTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String WORKDAY_NAMES
            = "허브,쥬니,말랑,라온,헤나,우코,에단,수달,파워,히이로,마코,슬링키,모디,연어,깃짱,리오,고니,박스터,달리,조이,노아이즈,도이,도치,홍고,스캇,폴로,해시,로지,첵스,아이크,우가,푸만능,애쉬,로이스,오션";
    private static final String HOLIDAY_NAMES
            = "오션,로이스,애쉬,푸만능,우가,아이크,첵스,로지,해시,폴로,스캇,홍고,도치,도이,노아이즈,조이,달리,박스터,고니,리오,깃짱,연어,모디,슬링키,마코,히이로,파워,수달,에단,우코,헤나,라온,말랑,쥬니,허브";

    @Test
    void 기능_테스트_평일이며_휴일은_추가_표시() {
        assertSimpleTest(() -> {
            run(
                    "5,월",
                    "준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리",
                    "수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니"
            );
            assertThat(output()).contains(
                    "5월 1일 월 준팍" + LINE_SEPARATOR,
                    "5월 2일 화 도밥" + LINE_SEPARATOR,
                    "5월 3일 수 고니" + LINE_SEPARATOR,
                    "5월 4일 목 수아" + LINE_SEPARATOR,
                    "5월 5일 금(휴일) 루루" + LINE_SEPARATOR,
                    "5월 6일 토 수아" + LINE_SEPARATOR,
                    "5월 7일 일 글로" + LINE_SEPARATOR,
                    "5월 8일 월 루루" + LINE_SEPARATOR,
                    "5월 9일 화 글로" + LINE_SEPARATOR,
                    "5월 10일 수 솔로스타" + LINE_SEPARATOR,
                    "5월 11일 목 우코" + LINE_SEPARATOR,
                    "5월 12일 금 슬링키" + LINE_SEPARATOR,
                    "5월 13일 토 솔로스타" + LINE_SEPARATOR,
                    "5월 14일 일 우코" + LINE_SEPARATOR,
                    "5월 15일 월 참새" + LINE_SEPARATOR,
                    "5월 16일 화 도리" + LINE_SEPARATOR,
                    "5월 17일 수 준팍" + LINE_SEPARATOR,
                    "5월 18일 목 도밥" + LINE_SEPARATOR,
                    "5월 19일 금 고니" + LINE_SEPARATOR,
                    "5월 20일 토 슬링키" + LINE_SEPARATOR,
                    "5월 21일 일 참새" + LINE_SEPARATOR,
                    "5월 22일 월 수아" + LINE_SEPARATOR,
                    "5월 23일 화 루루" + LINE_SEPARATOR,
                    "5월 24일 수 글로" + LINE_SEPARATOR,
                    "5월 25일 목 솔로스타" + LINE_SEPARATOR,
                    "5월 26일 금 우코" + LINE_SEPARATOR,
                    "5월 27일 토 도리" + LINE_SEPARATOR,
                    "5월 28일 일 준팍" + LINE_SEPARATOR,
                    "5월 29일 월 슬링키" + LINE_SEPARATOR,
                    "5월 30일 화 참새" + LINE_SEPARATOR,
                    "5월 31일 수 도리"
            );
        });
    }

    @Test
    void 기능_테스트_연속근무는_스위칭() {
        assertSimpleTest(() -> {
            run(
                    "5,월",
                    "1,2,3,4,5",
                    "4,3,2,1,5"
            );
            assertThat(output()).contains(
                    "5월 1일 월 1" + LINE_SEPARATOR,
                    "5월 2일 화 2" + LINE_SEPARATOR,
                    "5월 3일 수 3" + LINE_SEPARATOR,
                    "5월 4일 목 4" + LINE_SEPARATOR,
                    "5월 5일 금(휴일) 3" + LINE_SEPARATOR,
                    "5월 6일 토 4" + LINE_SEPARATOR,
                    "5월 7일 일 2" + LINE_SEPARATOR,
                    "5월 8일 월 5" + LINE_SEPARATOR,
                    "5월 9일 화 1" + LINE_SEPARATOR,
                    "5월 10일 수 2" + LINE_SEPARATOR,
                    "5월 11일 목 3" + LINE_SEPARATOR,
                    "5월 12일 금 4" + LINE_SEPARATOR,
                    "5월 13일 토 1" + LINE_SEPARATOR,
                    "5월 14일 일 5" + LINE_SEPARATOR,
                    "5월 15일 월 1" + LINE_SEPARATOR,
                    "5월 16일 화 5" + LINE_SEPARATOR,
                    "5월 17일 수 2" + LINE_SEPARATOR,
                    "5월 18일 목 3" + LINE_SEPARATOR,
                    "5월 19일 금 4" + LINE_SEPARATOR,
                    "5월 20일 토 3" + LINE_SEPARATOR,
                    "5월 21일 일 4" + LINE_SEPARATOR,
                    "5월 22일 월 5" + LINE_SEPARATOR,
                    "5월 23일 화 1" + LINE_SEPARATOR,
                    "5월 24일 수 2" + LINE_SEPARATOR,
                    "5월 25일 목 3" + LINE_SEPARATOR,
                    "5월 26일 금 4" + LINE_SEPARATOR,
                    "5월 27일 토 2" + LINE_SEPARATOR,
                    "5월 28일 일 1" + LINE_SEPARATOR,
                    "5월 29일 월 5" + LINE_SEPARATOR,
                    "5월 30일 화 1" + LINE_SEPARATOR,
                    "5월 31일 수 2"
            );
        });
    }

    @Test
    void January_테스트() {
        assertSimpleTest(() -> {
            run(
                    "1,월",
                    WORKDAY_NAMES,
                    HOLIDAY_NAMES
            );
            assertThat(output()).contains(
                    "1월 1일 월(휴일) 오션" + LINE_SEPARATOR,
                    "1월 2일 화 허브" + LINE_SEPARATOR,
                    "1월 3일 수 쥬니" + LINE_SEPARATOR,
                    "1월 4일 목 말랑" + LINE_SEPARATOR,
                    "1월 5일 금 라온" + LINE_SEPARATOR,
                    "1월 6일 토 로이스" + LINE_SEPARATOR,
                    "1월 7일 일 애쉬" + LINE_SEPARATOR,
                    "1월 8일 월 헤나" + LINE_SEPARATOR,
                    "1월 9일 화 우코" + LINE_SEPARATOR,
                    "1월 10일 수 에단" + LINE_SEPARATOR,
                    "1월 11일 목 수달" + LINE_SEPARATOR,
                    "1월 12일 금 파워" + LINE_SEPARATOR,
                    "1월 13일 토 푸만능" + LINE_SEPARATOR,
                    "1월 14일 일 우가" + LINE_SEPARATOR,
                    "1월 15일 월 히이로" + LINE_SEPARATOR,
                    "1월 16일 화 마코" + LINE_SEPARATOR,
                    "1월 17일 수 슬링키" + LINE_SEPARATOR,
                    "1월 18일 목 모디" + LINE_SEPARATOR,
                    "1월 19일 금 연어" + LINE_SEPARATOR,
                    "1월 20일 토 아이크" + LINE_SEPARATOR,
                    "1월 21일 일 첵스" + LINE_SEPARATOR,
                    "1월 22일 월 깃짱" + LINE_SEPARATOR,
                    "1월 23일 화 리오" + LINE_SEPARATOR,
                    "1월 24일 수 고니" + LINE_SEPARATOR,
                    "1월 25일 목 박스터" + LINE_SEPARATOR,
                    "1월 26일 금 달리" + LINE_SEPARATOR,
                    "1월 27일 토 로지" + LINE_SEPARATOR,
                    "1월 28일 일 해시" + LINE_SEPARATOR,
                    "1월 29일 월 조이" + LINE_SEPARATOR,
                    "1월 30일 화 노아이즈" + LINE_SEPARATOR,
                    "1월 31일 수 도이"
            );
        });
    }

    @Test
    void February_테스트() {
        assertSimpleTest(() -> {
            run(
                    "2,수",
                    WORKDAY_NAMES,
                    HOLIDAY_NAMES
            );
            assertThat(output()).contains(
                    "2월 1일 수 허브" + LINE_SEPARATOR,
                    "2월 2일 목 쥬니" + LINE_SEPARATOR,
                    "2월 3일 금 말랑" + LINE_SEPARATOR,
                    "2월 4일 토 오션" + LINE_SEPARATOR,
                    "2월 5일 일 로이스" + LINE_SEPARATOR,
                    "2월 6일 월 라온" + LINE_SEPARATOR,
                    "2월 7일 화 헤나" + LINE_SEPARATOR,
                    "2월 8일 수 우코" + LINE_SEPARATOR,
                    "2월 9일 목 에단" + LINE_SEPARATOR,
                    "2월 10일 금 수달" + LINE_SEPARATOR,
                    "2월 11일 토 애쉬" + LINE_SEPARATOR,
                    "2월 12일 일 푸만능" + LINE_SEPARATOR,
                    "2월 13일 월 파워" + LINE_SEPARATOR,
                    "2월 14일 화 히이로" + LINE_SEPARATOR,
                    "2월 15일 수 마코" + LINE_SEPARATOR,
                    "2월 16일 목 슬링키" + LINE_SEPARATOR,
                    "2월 17일 금 모디" + LINE_SEPARATOR,
                    "2월 18일 토 우가" + LINE_SEPARATOR,
                    "2월 19일 일 아이크" + LINE_SEPARATOR,
                    "2월 20일 월 연어" + LINE_SEPARATOR,
                    "2월 21일 화 깃짱" + LINE_SEPARATOR,
                    "2월 22일 수 리오" + LINE_SEPARATOR,
                    "2월 23일 목 고니" + LINE_SEPARATOR,
                    "2월 24일 금 박스터" + LINE_SEPARATOR,
                    "2월 25일 토 첵스" + LINE_SEPARATOR,
                    "2월 26일 일 로지" + LINE_SEPARATOR,
                    "2월 27일 월 달리" + LINE_SEPARATOR,
                    "2월 28일 화 조이"
            );
            assertFalse(output().contains("2월 29일"));
        });
    }

    private static Stream<Arguments> 잘못된_멤버_입력() {
        return Stream.of(
                Arguments.of(WORKDAY_NAMES + ",멤버", HOLIDAY_NAMES + ",멤버"), // 닉네임 개수 초과
                Arguments.of("한명", "한명"), // 닉네임 개수 부족
                Arguments.of("","") // 닉네임 개수 부족
        );
    }

    @ParameterizedTest
    @MethodSource("잘못된_멤버_입력")
    void 예외_테스트_잘못된_멤버_입력(String wrongWorkdayNames, String wrongHolidayNames) {
        assertSimpleTest(() -> {
            run("4,토",
                    wrongWorkdayNames,
                    WORKDAY_NAMES,
                    wrongHolidayNames,
                    WORKDAY_NAMES,
                    HOLIDAY_NAMES
            );
            assertThat(output()).contains(
                    "[ERROR]",
                    "4월 1일 토 오션" + LINE_SEPARATOR,
                    "4월 2일 일 로이스" + LINE_SEPARATOR,
                    "4월 3일 월 허브" + LINE_SEPARATOR,
                    "4월 4일 화 쥬니" + LINE_SEPARATOR,
                    "4월 5일 수 말랑" + LINE_SEPARATOR,
                    "4월 6일 목 라온" + LINE_SEPARATOR,
                    "4월 7일 금 헤나" + LINE_SEPARATOR,
                    "4월 8일 토 애쉬" + LINE_SEPARATOR,
                    "4월 9일 일 푸만능" + LINE_SEPARATOR,
                    "4월 10일 월 우코" + LINE_SEPARATOR,
                    "4월 11일 화 에단" + LINE_SEPARATOR,
                    "4월 12일 수 수달" + LINE_SEPARATOR,
                    "4월 13일 목 파워" + LINE_SEPARATOR,
                    "4월 14일 금 히이로" + LINE_SEPARATOR,
                    "4월 15일 토 우가" + LINE_SEPARATOR,
                    "4월 16일 일 아이크" + LINE_SEPARATOR,
                    "4월 17일 월 마코" + LINE_SEPARATOR,
                    "4월 18일 화 슬링키" + LINE_SEPARATOR,
                    "4월 19일 수 모디" + LINE_SEPARATOR,
                    "4월 20일 목 연어" + LINE_SEPARATOR,
                    "4월 21일 금 깃짱" + LINE_SEPARATOR,
                    "4월 22일 토 첵스" + LINE_SEPARATOR,
                    "4월 23일 일 로지" + LINE_SEPARATOR,
                    "4월 24일 월 리오" + LINE_SEPARATOR,
                    "4월 25일 화 고니" + LINE_SEPARATOR,
                    "4월 26일 수 박스터" + LINE_SEPARATOR,
                    "4월 27일 목 달리" + LINE_SEPARATOR,
                    "4월 28일 금 조이" + LINE_SEPARATOR,
                    "4월 29일 토 해시" + LINE_SEPARATOR,
                    "4월 30일 일 폴로"
            );
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,일", "4,-", "4,1"})
    void 예외_테스트_잘못된_월과_요일(String input) {
        assertSimpleTest(() -> {
            run(input,
                    "4,토",
                    WORKDAY_NAMES,
                    HOLIDAY_NAMES
            );
            assertThat(output()).contains(
                    "[ERROR]",
                    "4월 1일 토 오션" + LINE_SEPARATOR,
                    "4월 2일 일 로이스" + LINE_SEPARATOR,
                    "4월 3일 월 허브" + LINE_SEPARATOR,
                    "4월 4일 화 쥬니" + LINE_SEPARATOR,
                    "4월 5일 수 말랑" + LINE_SEPARATOR,
                    "4월 6일 목 라온" + LINE_SEPARATOR,
                    "4월 7일 금 헤나" + LINE_SEPARATOR,
                    "4월 8일 토 애쉬" + LINE_SEPARATOR,
                    "4월 9일 일 푸만능" + LINE_SEPARATOR,
                    "4월 10일 월 우코" + LINE_SEPARATOR,
                    "4월 11일 화 에단" + LINE_SEPARATOR,
                    "4월 12일 수 수달" + LINE_SEPARATOR,
                    "4월 13일 목 파워" + LINE_SEPARATOR,
                    "4월 14일 금 히이로" + LINE_SEPARATOR,
                    "4월 15일 토 우가" + LINE_SEPARATOR,
                    "4월 16일 일 아이크" + LINE_SEPARATOR,
                    "4월 17일 월 마코" + LINE_SEPARATOR,
                    "4월 18일 화 슬링키" + LINE_SEPARATOR,
                    "4월 19일 수 모디" + LINE_SEPARATOR,
                    "4월 20일 목 연어" + LINE_SEPARATOR,
                    "4월 21일 금 깃짱" + LINE_SEPARATOR,
                    "4월 22일 토 첵스" + LINE_SEPARATOR,
                    "4월 23일 일 로지" + LINE_SEPARATOR,
                    "4월 24일 월 리오" + LINE_SEPARATOR,
                    "4월 25일 화 고니" + LINE_SEPARATOR,
                    "4월 26일 수 박스터" + LINE_SEPARATOR,
                    "4월 27일 목 달리" + LINE_SEPARATOR,
                    "4월 28일 금 조이" + LINE_SEPARATOR,
                    "4월 29일 토 해시" + LINE_SEPARATOR,
                    "4월 30일 일 폴로"
            );
        });
    }

    @Test
    void 연속_근무자_중첩_기능_테스트() {
        assertSimpleTest(() -> {
            run(
                    "5,월",
                    "준팍,도밥,고니,수아,글로,루루,솔로스타,우코,슬링키,참새,도리",
                    "수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니"
            );
            assertThat(output()).contains(
                    "5월 1일 월 준팍" + LINE_SEPARATOR,
                    "5월 2일 화 도밥" + LINE_SEPARATOR,
                    "5월 3일 수 고니" + LINE_SEPARATOR,
                    "5월 4일 목 수아" + LINE_SEPARATOR,
                    "5월 5일 금(휴일) 루루" + LINE_SEPARATOR,
                    "5월 6일 토 수아" + LINE_SEPARATOR,
                    "5월 7일 일 글로" + LINE_SEPARATOR,
                    "5월 8일 월 루루" + LINE_SEPARATOR,
                    "5월 9일 화 글로" + LINE_SEPARATOR,
                    "5월 10일 수 솔로스타" + LINE_SEPARATOR,
                    "5월 11일 목 우코" + LINE_SEPARATOR,
                    "5월 12일 금 슬링키" + LINE_SEPARATOR,
                    "5월 13일 토 솔로스타" + LINE_SEPARATOR,
                    "5월 14일 일 우코" + LINE_SEPARATOR,
                    "5월 15일 월 참새" + LINE_SEPARATOR,
                    "5월 16일 화 도리" + LINE_SEPARATOR,
                    "5월 17일 수 준팍" + LINE_SEPARATOR,
                    "5월 18일 목 도밥" + LINE_SEPARATOR,
                    "5월 19일 금 고니" + LINE_SEPARATOR,
                    "5월 20일 토 슬링키" + LINE_SEPARATOR,
                    "5월 21일 일 참새" + LINE_SEPARATOR,
                    "5월 22일 월 수아" + LINE_SEPARATOR,
                    "5월 23일 화 글로" + LINE_SEPARATOR,
                    "5월 24일 수 루루" + LINE_SEPARATOR,
                    "5월 25일 목 솔로스타" + LINE_SEPARATOR,
                    "5월 26일 금 우코" + LINE_SEPARATOR,
                    "5월 27일 토 도리" + LINE_SEPARATOR,
                    "5월 28일 일 준팍" + LINE_SEPARATOR,
                    "5월 29일 월 슬링키" + LINE_SEPARATOR,
                    "5월 30일 화 참새" + LINE_SEPARATOR,
                    "5월 31일 수 도리"
            );
        });
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

