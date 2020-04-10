package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    @DisplayName("주어진 결제 수단 외 선택 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3, 4, 5, 6})
    void findBy(int number) {
        assertThatThrownBy(() -> {
            Payment payment = Payment.findBy(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("선택할 수 없는 결제 수단입니다.");
    }
}
