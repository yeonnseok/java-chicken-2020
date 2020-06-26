package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenusTest {
    private Menus menus;

    @BeforeEach
    void setUp() {
        menus = new Menus();
    }

    @DisplayName("메뉴 생성")
    @Test
    void constructor() {
        assertThat(menus.getMenus()).hasSize(8);
    }

    @DisplayName("목록에 없는 메뉴 번호 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 7, 8, 9, 10, 100})
    void findByFail(int number) {
        assertThatThrownBy(() -> {
            Menu menu = menus.findBy(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 메뉴 입니다.");

    }
}
