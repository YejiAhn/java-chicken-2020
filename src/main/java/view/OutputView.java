package view;

import java.util.List;

import domain.Menu;
import domain.Table;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_FOR_ORDERED_TABLE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(List<Table> tables, final int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Table table : tables) {
            differBottomLineByOrdering(stringBuilder, table);
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }

    private static void differBottomLineByOrdering(StringBuilder stringBuilder, Table table) {
        if (table.hasOrdered()) {
            stringBuilder.append(BOTTOM_LINE_FOR_ORDERED_TABLE);
        }
        if (!table.hasOrdered()) {
            stringBuilder.append(BOTTOM_LINE);
        }
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrders(Table table) {
        System.out.println("## 주문 내역\n메뉴 수량 금액");
        System.out.println(table.getOrderedMenu());
    }

    public static void printFinalAmountDue(double money) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(money + "원");
    }

    public static void printTerminateMessage() {
        System.out.println("프로그램을 종료합니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
