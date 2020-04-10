package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuantityTest {

    @DisplayName("최소 수량(=1), 최대 수량(=99) 범위를 벗어날 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 100, 1000})
    void constructorMin(int value) {
        assertThatThrownBy(() -> {
            Quantity quantity = new Quantity(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("메뉴당 최소 1개, 최대 99개까지 주문 가능 합니다.");
    }

    @DisplayName("같은 메뉴 주문 추가 시 수량 증가")
    @ParameterizedTest
    @CsvSource({"1,51", "2,52", "3,53", "4,54", "49,99"})
    void addQuantity(int value, int expectedQuantity) {
        Quantity quantity = new Quantity(50);
        Quantity nextQuantity = quantity.addQuantity(new Quantity(value));
        assertThat(nextQuantity).isEqualTo(new Quantity(expectedQuantity));
    }

    @DisplayName("같은 메뉴 주문 추가 시 수량 99 초과할 경우 예외 발생")
    @Test
    void addQuantityFail() {
        Quantity quantity = new Quantity(50);
        assertThatThrownBy(() -> {
            Quantity newQuantity = quantity.addQuantity(new Quantity(50));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("메뉴당 최소 1개, 최대 99개까지 주문 가능 합니다.");
    }
}
