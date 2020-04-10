package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    public static Menu menuChicken = new Menu(3, "가메뉴", Category.CHICKEN, 18000);
    public static Menu menuBeverage = new Menu(4, "가메뉴2", Category.BEVERAGE, 1000);

    @Test
    @DisplayName("메뉴의 번호가 같을 시 hasSameNumber 메소드가 true 값을 잘 반환하는지")
    void hasSameNumber() {
        assertThat(menuChicken.hasSameMenuNumber("3")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "4", "-"})
    @DisplayName("메뉴의 번호가 다를 시 hasSameNumber 메소드가 false 값을 잘 반환하는지")
    void hasDifferentNumber(String menuNumber) {
        assertThat(menuChicken.hasSameMenuNumber(menuNumber)).isFalse();
    }
}
