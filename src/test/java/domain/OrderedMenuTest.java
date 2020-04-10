package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedMenuTest {

    @Test
    @DisplayName("비었을 때 isEmpty() 메서드가 true를 반환하고, 아닐 때 false 반환하는지")
    void isEmpty() {
        OrderedMenu orderedMenu = new OrderedMenu();
        assertThat(orderedMenu.isEmpty()).isTrue();
        orderedMenu.add(MenuTest.menuChicken, 3);
        assertThat(orderedMenu.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("주문이 들어갔을 때 제대로 추가되어 결제금액이 제대로 반환되는지")
    void calculateAmountDue() {
        OrderedMenu orderedMenu = new OrderedMenu();
        orderedMenu.add(MenuTest.menuChicken, 4);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(72000);
        orderedMenu.add(MenuTest.menuChicken, 6);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(170000);
        orderedMenu.add(MenuTest.menuBeverage, 3);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(173000);
        orderedMenu.add(MenuTest.menuChicken, 1);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(191000);
    }
}
