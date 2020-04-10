package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @DisplayName("메뉴 가격에 수량을 곱한 실 주문 가격 반환")
    @Test
    void price() {
        Order order = new Order(new Menu(1, "후라이드", Category.CHICKEN, 16_000),
                new Quantity(10));

        assertThat(order.calculateOrderPrice()).isEqualTo(160_000);
    }

}
