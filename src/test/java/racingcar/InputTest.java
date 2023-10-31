package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.valid.ValidationManager;

public class InputTest {

    @Test
    void 테스트_모두_유효한_자동차이름() {
        // given
        String inputCarNames = "우아,한,테크,코스";
        //then
        assertDoesNotThrow(() -> ValidationManager.validateCarNames(inputCarNames));
    }

    @Test
    void 테스트_5자_초과_자동차이름() {
        // given
        String inputCarNames = "우아,하아안,테크으으으으,코스으으으으";
        // then
        assertThatThrownBy(() -> ValidationManager.validateCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테스트_공백포함() {
        // given
        String inputCarNames = "우아, ,한,테크";
        // then
        assertThatThrownBy(() -> ValidationManager.validateCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테스트_유효한_시도횟수_입력() {
        // given
        String inputTryCount = "123";
        // then
        assertDoesNotThrow(() -> ValidationManager.validateTryCount(inputTryCount));
    }

    @Test
    void 테스트_문자포함_시도횟수_입력() {
        // given
        String inputTryCount = "12,3";
        // then
        assertThatThrownBy(() -> ValidationManager.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테스트_0으로시작_시도횟수_입력() {
        // given
        String inputTryCount = "012";
        // then
        assertThatThrownBy(() -> ValidationManager.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 테스트_비어있는_시도횟수_입력() {
        // given
        String inputTryCount = " ";
        // then
        assertThatThrownBy(() -> ValidationManager.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
