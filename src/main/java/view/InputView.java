package view;

import java.util.List;
import java.util.Scanner;

import domain.ChoiceInMain;
import domain.Menu;
import domain.Table;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static ChoiceInMain inputChoiceInMain() {
        System.out.println("## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n");
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            return ChoiceInMain.of(scanner.nextLine());
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputChoiceInMain();
        }
    }

    public static Table inputTableNumber(List<Table> tables) {
        System.out.println("## 테이블을 선택하세요.");
        try {
            String tableNumber = scanner.nextLine();
            return tables.stream()
                .filter(table -> table.hasSameTableNumber(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 테이블 번호입니다."));
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputTableNumber(tables);
        }
    }

    public static Menu inputMenuNumber(List<Menu> menus) {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        try {
            String menuNumber = scanner.nextLine();
            return menus.stream()
                .filter(menu -> menu.hasSameMenuNumber(menuNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 메뉴 번호입니다."));
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputMenuNumber(menus);
        }
    }

    public static int inputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요");
        try {
            String menuQuantityString = scanner.nextLine();
            return Integer.parseInt(menuQuantityString);
        } catch (Exception e) {
            OutputView.printErrorMessage("메뉴 수량은 숫자로 입력해주세요.");
            return inputMenuQuantity();
        }
    }
}
