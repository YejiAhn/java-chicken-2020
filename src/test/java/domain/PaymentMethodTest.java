package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentMethodTest {
    @ParameterizedTest
    @DisplayName("올바르지 않은 값이 들어갔을 경우 예외를 잘 처리하는지")
    @ValueSource(strings = {"4", "0", "a", "<"})
    void paymentInvalid(String input) {
        assertThatThrownBy(() -> {
            PaymentMethod.of(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("결제 방법은 1이나 2로만 답해주세요.");
    }

    @ParameterizedTest
    @DisplayName("올바른 값이 들어갔을 경우 예외가 발생하지 않는지")
    @ValueSource(strings = {"1", "2"})
    void paymentValid(String input) {
        assertThat(PaymentMethod.of(input)).isInstanceOf(PaymentMethod.class);
    }

    @Test
    @DisplayName("현금 할인이 제대로 들어가는지, 카드는 할인이 되지 않는지")
    void cashDiscount() {
        final PaymentMethod cash = PaymentMethod.CASH;
        final PaymentMethod card = PaymentMethod.CREDIT_CARD;
        final double discountedAmount = cash.handleCashDiscount(100);
        final double notDiscountedAmount = card.handleCashDiscount(100);
        assertThat(discountedAmount).isEqualTo(95);
        assertThat(notDiscountedAmount).isEqualTo(100);
    }
}
