package view;

import java.util.Scanner;

import domain.ChoiceInMain;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static ChoiceInMain inputChoiceInMain() {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            return ChoiceInMain.of(scanner.nextLine());
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputChoiceInMain();
        }
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
