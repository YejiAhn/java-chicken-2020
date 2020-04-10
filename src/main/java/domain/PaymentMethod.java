package domain;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum PaymentMethod {
    CREDIT_CARD("1", a -> a),
    CASH("2", a -> a * 0.95);

    private String methodNumber;
    private UnaryOperator<Double> discountProcess;

    PaymentMethod(String methodNumber, UnaryOperator<Double> discountProcess) {
        this.methodNumber = methodNumber;
        this.discountProcess = discountProcess;
    }

    public static PaymentMethod of(String methodNumber) {
        return Arrays.stream(PaymentMethod.values())
            .filter(paymentMethod -> paymentMethod.methodNumber.equals(methodNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("결제 방법은 1이나 2로만 답해주세요."));
    }

    public double handleCashDiscount(double originalPrice) {
        return this.discountProcess.apply(originalPrice);
    }
}
