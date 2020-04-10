package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedMenuTest {
    private OrderedMenu orderedMenu = new OrderedMenu();

    @BeforeEach
    void setUp() {
        OrderedMenu orderedMenu = new OrderedMenu();
    }

    @Test
    @DisplayName("비었을 때 isEmpty() 메서드가 true를 반환하고, 아닐 때 false 반환하는지")
    void isEmpty() {
        assertThat(orderedMenu.hasNoOrderedMenu()).isTrue();
        orderedMenu.add(MenuTest.chickenMenu1, 3);
        assertThat(orderedMenu.hasNoOrderedMenu()).isFalse();
    }

    @Test
    @DisplayName("주문이 들어갔을 때 제대로 추가되어 결제금액이 제대로 반환되는지")
    void calculateAmountDue() {
        OrderedMenu orderedMenu = new OrderedMenu();
        orderedMenu.add(MenuTest.chickenMenu1, 4);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(72000);
        orderedMenu.add(MenuTest.chickenMenu1, 6);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(170000);
        orderedMenu.add(MenuTest.beverageMenu1, 3);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(173000);
        orderedMenu.add(MenuTest.chickenMenu1, 1);
        assertThat(orderedMenu.calculateAmountDue()).isEqualTo(191000);
    }

    @Test
    @DisplayName("한 테이블에서 한번에 주문한 한 메뉴의 수량이 99개 초과일 때 예외를 잘 처리하는지")
    void overQuantityLimitAtOnce() {
        assertThatThrownBy(() -> {
            orderedMenu.add(MenuTest.chickenMenu1, 100);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("한 메뉴의 최대 수량은");
    }

    @Test
    @DisplayName("한 테이블에서 여러 번에 나눠서 주문한 한 메뉴의 수량이 99개 초과일 때 예외를 잘 처리하는지")
    void overQuantityLimit() {
        orderedMenu.add(MenuTest.chickenMenu1, 50);
        assertThatThrownBy(() -> {
            orderedMenu.add(MenuTest.chickenMenu1, 50);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("한 메뉴의 최대 수량은");
    }

    @Test
    @DisplayName("toString 메서드가 제대로 동작하는지")
    void toStringTest() {
        orderedMenu.add(MenuTest.chickenMenu1, 1);
        assertThat(orderedMenu.toString()).isEqualTo("가메뉴 1 18000\n");
    }
}
