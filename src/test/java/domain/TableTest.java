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
}
