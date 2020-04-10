package domain;

import java.util.Objects;

public class Quantity {
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 99;

    private final int quantity;

    public Quantity(final int quantity) {
        if (quantity < MIN_QUANTITY | quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("메뉴당 최소 1개, 최대 99개까지 주문 가능 합니다.");
        }
        this.quantity = quantity;
    }

    public Quantity addQuantity(final int value) {
        return new Quantity(quantity + value);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
