package domain;

import java.util.List;

public class Menus {
    private static List<Menu> menus;

    public Menus() {
        menus = MenuRepository.menus();
    }

    public int size() {
        return menus.size();
    }

    public Menu findBy(final int number) {
        return menus.stream()
                .filter(menu -> menu.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴 입니다."));
    }
}
