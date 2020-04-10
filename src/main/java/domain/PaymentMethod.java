package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CREDIT_CARD("1"),
    CASH("2");

    private String methodNumber;

    PaymentMethod(String methodNumber) {
        this.methodNumber = methodNumber;
    }

    public static PaymentMethod of(String methodNumber) {
        return Arrays.stream(PaymentMethod.values())
            .filter(paymentMethod -> paymentMethod.methodNumber.equals(methodNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("결제 방법은 1이나 2로만 답해주세요."));
    }
}
