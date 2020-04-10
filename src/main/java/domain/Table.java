package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    public static final int INITIAL_VALUE_ZERO = 0;
    private final int number;
    private Map<Menu, Integer> orderedMenu = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean hasSameTableNumber(String number) {
        return String.valueOf(this.number).equals(number);
    }

    public void order(Menu menu, int menuQuantity) {
        int totalQuantityForSpecificMenu = orderedMenu.getOrDefault(menu, INITIAL_VALUE_ZERO) + menuQuantity;
        if (totalQuantityForSpecificMenu > 99) {
            throw new IllegalArgumentException("한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개입니다.");
        }
        orderedMenu.put(menu, orderedMenu.getOrDefault(menu, INITIAL_VALUE_ZERO) + menuQuantity);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
