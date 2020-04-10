package domain;

import java.util.Arrays;

public enum ChoiceInMain {
    ORDER("1"),
    PAY("2"),
    TERMINATE("3");

    private String choiceNumber;

    ChoiceInMain(String choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    public static ChoiceInMain of(String number) {
        return Arrays.stream(ChoiceInMain.values())
            .filter(choice -> choice.getNumber().equals(number))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력값입니다."));
    }

    private String getNumber() {
        return choiceNumber;
    }
}
