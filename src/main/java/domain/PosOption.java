package domain;

import java.util.Arrays;

public enum PosOption {
    ORDER(1),
    PAY(2),
    TERMINATE(3);

    private final int number;

    PosOption(final int number) {
        this.number = number;
    }

    public static PosOption findBy(final int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 옵션입니다."));
    }
}
