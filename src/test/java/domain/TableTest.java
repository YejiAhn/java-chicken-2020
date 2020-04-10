package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {
    private Table table;
    private Menu menu = new Menu(3, "가메뉴", Category.BEVERAGE, 17000);

    @BeforeEach
    void setUp() {
        table = new Table(1);
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
    @DisplayName("한 테이블에서 한번에 주문한 한 메뉴의 수량이 99개 초과일 때 예외를 잘 처리하는지")
    void overQuantityLimit() {
        Table table = new Table(3);
        table.order(menu, 50);
        assertThatThrownBy(() -> {
            table.order(menu, 50);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("한 메뉴의 최대 수량은");

    }
}
