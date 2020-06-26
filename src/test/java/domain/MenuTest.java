package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    public void getPrice() {
        Menu menu = new Menu(1, "후라이드 치킨", Category.CHICKEN, 21000);
        assertThat(menu.getName()).isEqualTo("후라이드 치킨");
        assertThat(menu.getPrice()).isEqualTo(21000);
        assertThat(menu.getNumber()).isEqualTo(1);
    }

}