package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> orderedMenu = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean hasSameTableNumber(String number) {
        return String.valueOf(this.number).equals(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
