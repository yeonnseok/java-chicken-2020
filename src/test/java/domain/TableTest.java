package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {
    private Table table;
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        table = new Table(2);
    }

    @DisplayName("Order 추가")
    @Test
    void addOrder() {
        assertThat(table.isOrdering()).isFalse();
        table.addOrder(menu, new Quantity(14));
        assertThat(table.isOrdering()).isTrue();
    }

    @DisplayName("주문 초기화")
    @Test
    void clearOrder() {
        table.addOrder(menu, new Quantity(14));
        assertThat(table.getOrders().getOrders()).hasSize(1);

        table.clear();
        assertThat(table.getOrders().getOrders()).hasSize(0);
    }

    @DisplayName("번호로 테이블 식별")
    @Test
    void equals() {
        Table table1 = new Table(5);
        Table table2 = new Table(5);
        assertThat(table1.equals(table2)).isTrue();
    }

}
