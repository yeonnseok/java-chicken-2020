package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceCalculatorTest {
    private Orders orders;
    private PriceCalculator priceCalculator;

    @BeforeEach
    void setUp() {
        orders = new Orders();
        orders.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000), new Quantity(14));
        orders.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000), new Quantity(21));
    }

    @DisplayName("치킨 카테코리 메뉴 개수가 10개 단위로 10_000원씩 할인")
    @Test
    void calculateTotalPriceAfterChickenDiscount() {
        priceCalculator = new PriceCalculator(orders, Payment.CARD);
        double price = priceCalculator.calculateTotalPrice();
        assertThat(price).isEqualTo(551_000);
    }

    @DisplayName("결제 수단이 현금일 경우 5% 추가 할인")
    @Test
    void calculateTotalPriceAfterCashDiscount() {
        priceCalculator = new PriceCalculator(orders, Payment.CASH);
        double price = priceCalculator.calculateTotalPrice();
        assertThat(price).isEqualTo(523_450);
    }



}
