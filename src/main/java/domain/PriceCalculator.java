package domain;

public class PriceCalculator {
    private static final int CHICKEN_DISCOUNT_AMOUNT = 10_000;
    private static final int CHICKEN_DISCOUNT_UNIT = 10;

    private final Orders orders;
    private final Payment payment;

    public PriceCalculator(final Orders orders, final Payment payment) {
        this.orders = orders;
        this.payment = payment;
    }

    public double calculateTotalPrice() {
        int totalPrice = orders.calculateTotalPrice() - (orders.countOfChickenCategory() / CHICKEN_DISCOUNT_UNIT) * CHICKEN_DISCOUNT_AMOUNT;
        return payment.calculateFinalTotalPrice(totalPrice);
    }
}
