package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05);

    private final int number;
    private final double discountRatio;

    Payment(final int number, final double discountRatio) {
        this.number = number;
        this.discountRatio = discountRatio;
    }

    public static Payment findBy(final int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 결제 수단입니다."));
    }
}

