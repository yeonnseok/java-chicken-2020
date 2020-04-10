package domain;

public class Table {
    private final int number;
    private final Orders orders;

    public Table(final int number) {
        this.number = number;
        orders = new Orders();
    }

    public void addOrder(final Menu menu, final Quantity quantity) {
        orders.add(menu, quantity);
    }

    public boolean isOrdering() {
        return orders.size() > 0;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
