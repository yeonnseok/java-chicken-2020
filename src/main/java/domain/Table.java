package domain;

import java.util.Objects;

public class Table {
    private final int number;
    private Orders orders;

    public Table(final int number) {
        this.number = number;
        orders = new Orders();
    }

    public void addOrder(final Menu menu, final Quantity quantity) {
        orders.add(menu, quantity);
    }

    public void clear() {
        orders = new Orders();
    }

    public boolean isOrdering() {
        return orders.size() > 0;
    }

    public int getNumber() {
        return number;
    }

    public Orders getOrders() {
        return orders;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
