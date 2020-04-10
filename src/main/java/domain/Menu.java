package domain;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isChickenCategory() {
        return category == Category.CHICKEN;
    }

    public int getNumber() {
        return number;
    }

    public int getPriceBy(final Quantity quantity) {
        return price * quantity.getQuantity();
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
