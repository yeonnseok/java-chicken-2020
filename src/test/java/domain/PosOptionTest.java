package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PosOptionTest {
    @DisplayName("실행 가능한 옵션 외 선택 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 5, 6})
    void findBy(int number) {
        assertThatThrownBy(() -> {
            PosOption posOption = PosOption.findBy(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("선택할 수 없는 옵션입니다.");
    }
}
