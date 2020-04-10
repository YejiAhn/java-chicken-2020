package domain;

public class Table {
    private final int number;
    private OrderedMenu orderedMenu = new OrderedMenu();

    public Table(final int number) {
        this.number = number;
    }

    public boolean hasOrdered() {
        return !orderedMenu.hasNoOrderedMenu();
    }

    public boolean hasSameTableNumber(String number) {
        return String.valueOf(this.number).equals(number);
    }

    public void order(Menu menu, int menuQuantity) {
        orderedMenu.add(menu, menuQuantity);
    }

    public double calculateAmountDue() {
        return orderedMenu.calculateAmountDue();
    }

    public int getNumber() {
        return this.number;
    }

    public OrderedMenu getOrderedMenu() {
        return orderedMenu;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
