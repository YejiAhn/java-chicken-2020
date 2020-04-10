package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    public static Menu chickenMenu1 = new Menu(3, "가메뉴", Category.CHICKEN, 18000);
    public static Menu chickenMenu2 = new Menu(1, "가메뉴", Category.CHICKEN, 20000);
    public static Menu beverageMenu1 = new Menu(4, "가메뉴2", Category.BEVERAGE, 1000);

    @Test
    @DisplayName("메뉴의 번호가 같을 시 hasSameNumber 메소드가 true 값을 잘 반환하는지")
    void hasSameNumber() {
        assertThat(chickenMenu1.hasSameMenuNumber("3")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "4", "-"})
    @DisplayName("메뉴의 번호가 다를 시 hasSameNumber 메소드가 false 값을 잘 반환하는지")
    void hasDifferentNumber(String menuNumber) {
        assertThat(chickenMenu1.hasSameMenuNumber(menuNumber)).isFalse();
    }

    @Test
    @DisplayName("치킨인지 아닌지 판별하는 메소드가 잘 동작하는지")
    void isChickenCategory() {
        assertThat(MenuTest.chickenMenu1.isChickenCategory()).isTrue();
        assertThat(MenuTest.beverageMenu1.isChickenCategory()).isFalse();
    }

    @Test
    @DisplayName("메뉴의 이름이 잘 가져와지는지")
    void getName() {
        assertThat(MenuTest.chickenMenu1.getName()).isEqualTo("가메뉴");
    }

    @Test
    @DisplayName("메뉴의 가격이 잘 가져와지는지")
    void getPrice() {
        assertThat(MenuTest.chickenMenu1.getPrice()).isEqualTo(18000);
    }

    @Test
    @DisplayName("toString 메서드가 제대로 동작하는지")
    void toStringTest() {
        assertThat(MenuTest.chickenMenu1.toString()).isEqualTo("[치킨] 3 - 가메뉴 : 18000원");
    }
}
