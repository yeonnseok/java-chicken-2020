package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TablesTest {
    private Tables tables;

    @BeforeEach
    void setUp() {
        tables = new Tables();
    }

    @DisplayName("테이블 생성")
    @Test
    void constructor() {
        assertThat(tables.size()).isEqualTo(6);
    }

    @DisplayName("목록에 없는 테이블 번호 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 4, 7, 9, 10})
    void findByFail(int number) {
        assertThatThrownBy(() -> {
            Table table = tables.findBy(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 테이블 입니다.");
    }

    @DisplayName("테이블 번호로 테이블 찾기")
    @Test
    void findTable() {
        Tables tables = new Tables();
        tables.getTables().get(1).addOrder(
                new Menu(3, "후라이드 치킨", Category.CHICKEN, 21000),
                new Quantity(14)
        );
        final Table payTable = tables.findPayTableBy(2);
        assertThat(tables.getTables()).isNotNull();
        assertThat(payTable.getNumber()).isEqualTo(2);
    }
}

