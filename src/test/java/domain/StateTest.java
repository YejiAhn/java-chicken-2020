package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StateTest {

    @Test
    @DisplayName("State enum이 제대로 만들어졌는지")
    void stateTest() {
        assertThat(State.values().length).isEqualTo(3);
    }
}
