package domain;

import java.util.HashMap;
import java.util.Map;

public class OrderedMenu {
    public static final int DISCOUNT_AMOUNT_PER_TEN_CHICKENS = 10000;
    public static final int DISCOUNT_CHICKEN_NUMBER_CRITERION = 10;
    private static final int INITIAL_VALUE_ZERO = 0;
    private Map<Menu, Integer> orderedMenu = new HashMap<>();

    public boolean isEmpty() {
        return orderedMenu.isEmpty();
    }

    public void add(Menu menu, int menuQuantity) {
        int totalQuantityForSpecificMenu = orderedMenu.getOrDefault(menu, INITIAL_VALUE_ZERO) + menuQuantity;
        if (totalQuantityForSpecificMenu > 99) {
            throw new IllegalArgumentException("한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개입니다.");
        }
        orderedMenu.put(menu, orderedMenu.getOrDefault(menu, INITIAL_VALUE_ZERO) + menuQuantity);
    }

    public double calculateAmountDue() {
        double sum = 0;
        int chickenQuantity = 0;
        for (Menu menu : orderedMenu.keySet()) {
            sum += menu.getPrice() * orderedMenu.get(menu);
            chickenQuantity = countChickenQuantity(chickenQuantity, menu);
        }
        int discountNumber = chickenQuantity / DISCOUNT_CHICKEN_NUMBER_CRITERION;
        sum -= discountNumber * DISCOUNT_AMOUNT_PER_TEN_CHICKENS;
        return sum;
    }

    private int countChickenQuantity(int chickenQuantity, Menu menu) {
        if (menu.isChickenCategory()) {
            chickenQuantity += orderedMenu.get(menu);
        }
        return chickenQuantity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Menu menu : orderedMenu.keySet()) {
            int quantity = orderedMenu.get(menu);
            int amountDueForSpecificMenu = quantity * menu.getPrice();
            stringBuilder.append(menu.getName()).append(" ");
            stringBuilder.append(orderedMenu.get(menu)).append(" ");
            stringBuilder.append(amountDueForSpecificMenu).append("\n");
        }
        return stringBuilder.toString();
    }
}
