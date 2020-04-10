package domain;

public class Order {
    private final Menu menu;
    private final Quantity quantity;

    public Order(final Menu menu, final Quantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int calculateOrderPrice() {
        return menu.getPriceBy(quantity);
    }

    public boolean isChickenCategory() {
        return menu.isChickenCategory();
    }
}
