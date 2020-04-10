package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {
    private Menu menu1;
    private Menu menu2;
    private Orders orders;

    @BeforeEach
    void setUp() {
        menu1 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        menu2 = new Menu(6, "순살치킨", Category.CHICKEN, 17_000);
        orders = new Orders();
    }

    @DisplayName("선택된 메뉴와 수량을 추가")
    @Test
    void add() {
        orders.add(menu1, new Quantity(14));
        orders.add(menu2, new Quantity(21));
        assertThat(orders.size()).isEqualTo(2);
    }

    @DisplayName("치킨 메뉴의 10개 묶음 갯수")
    @Test
    void chickenTenUnitCount() {
        orders.add(menu1, new Quantity(14));
        orders.add(menu2, new Quantity(21));
        assertThat(orders.countOfChickenCategory()).isEqualTo(35);
    }

    @DisplayName("이미 있는 메뉴 추가 시 수량만 증가")
    @Test
    void existedMenu() {
        orders.add(menu1, new Quantity(14));
        orders.add(menu2, new Quantity(21));
        orders.add(menu1, new Quantity(10));
        assertThat(orders.size()).isEqualTo(2);
    }
}
