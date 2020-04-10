package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    private Menu menu = new Menu(3, "가메뉴", Category.CHICKEN, 18000);

    @Test
    @DisplayName("메뉴의 번호가 같을 시 hasSameNumber 메소드가 true 값을 잘 반환하는지")
    void hasSameNumber() {
        assertThat(menu.hasSameMenuNumber("3")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "4", "-"})
    @DisplayName("메뉴의 번호가 다를 시 hasSameNumber 메소드가 false 값을 잘 반환하는지")
    void hasDifferentNumber(String menuNumber) {
        assertThat(menu.hasSameMenuNumber(menuNumber)).isFalse();
    }
}
