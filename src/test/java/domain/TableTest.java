package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TableTest {
    private Table table;
    private Menu menu = new Menu(3, "가메뉴", Category.BEVERAGE, 17000);

    @BeforeEach
    void setUp() {
        table = new Table(1);
    }

    @Test
    @DisplayName("테이블의 번호가 같을 시 hasSameTableNumber 메소드가 true 값을 잘 반환하는지")
    void hasSameNumber() {
        assertThat(table.hasSameTableNumber("1")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "4", "-"})
    @DisplayName("메뉴의 번호가 다를 시 hasSameNumber 메소드가 false 값을 잘 반환하는지")
    void hasDifferentNumber(String tableNumber) {
        assertThat(table.hasSameTableNumber(tableNumber)).isFalse();
    }

    @Test
    @DisplayName("테이블에 주문이 들어갔을 시 hasOrdered 메소드가 true 값을 잘 반환하는지")
    void hasOrdered() {
        table.order(menu, 3);
        assertThat(table.hasOrdered()).isTrue();
    }

    @Test
    @DisplayName("테이블에 주문이 안 들어갔을 시 hasOrdered 메소드가 false 값을 잘 반환하는지")
    void hasNotOrdered() {
        assertThat(table.hasOrdered()).isFalse();
    }

    @Test
    @DisplayName("한 테이블에서 한번에 주문한 한 메뉴의 수량이 99개 초과일 때 예외를 잘 처리하는지")
    void overQuantityLimitAtOnce() {
        Table table = new Table(3);
        assertThatThrownBy(() -> {
            table.order(menu, 100);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("한 메뉴의 최대 수량은");
    }

    @Test
    @DisplayName("한 테이블에서 여러 번에 나눠서 주문한 한 메뉴의 수량이 99개 초과일 때 예외를 잘 처리하는지")
    void overQuantityLimit() {
        Table table = new Table(3);
        table.order(menu, 50);
        assertThatThrownBy(() -> {
            table.order(menu, 50);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("한 메뉴의 최대 수량은");

    }
}
