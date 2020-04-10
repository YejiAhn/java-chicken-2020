package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChoiceInMainTest {

    @ParameterizedTest
    @DisplayName("올바르지 않은 값이 들어갔을 경우 예외를 잘 처리하는지")
    @ValueSource(strings = {"4", "0", "a", "<"})
    void choiceInvalid(String input) {
        assertThatThrownBy(() -> {
            ChoiceInMain.of(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("올바르지 않은 입력값입니다.");
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 값이 들어갔을 경우 예외를 잘 처리하는지")
    @ValueSource(strings = {"1", "2", "3"})
    void choiceValid(String input) {
        assertThat(ChoiceInMain.of(input)).isInstanceOf(ChoiceInMain.class);
    }
}
