package domain;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private Map<Menu, Quantity> orders = new HashMap<>();

    public void add(final Menu menu, final Quantity quantity) {
        orders.put(menu, orders.getOrDefault(menu, new Quantity()).addQuantity(quantity));
    }

    public int size() {
        return orders.size();
    }

    public int countOfChickenCategory() {
        return orders.keySet().stream()
                .filter(Menu::isChickenCategory)
                .map(menu -> orders.get(menu))
                .mapToInt(Quantity::getQuantity)
                .sum();
    }

    public int calculateTotalPrice() {
        return orders.keySet().stream()
                .mapToInt(menu -> menu.getPriceBy(orders.get(menu)))
                .sum();
    }
}
