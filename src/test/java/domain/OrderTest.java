package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        final Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        final Quantity quantity = new Quantity(10);
        order = new Order(menu, quantity);
    }

    @DisplayName("메뉴 가격에 수량을 곱한 실 주문 가격 반환")
    @Test
    void price() {
        assertThat(order.calculateOrderPrice()).isEqualTo(160_000);
    }

    @DisplayName("치킨 메뉴 주문인지 확인")
    @Test
    void chickenCategory() {
        assertThat(order.isChickenCategory()).isTrue();
    }

}
