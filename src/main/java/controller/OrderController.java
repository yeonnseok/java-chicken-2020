package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class OrderController implements PosController {
    private Menus menus = new Menus();

    @Override
    public void run(final Table table) {
        OutputView.printMenus(menus.getMenus());
        Menu menu = findByMenuWithValidation(menus);
        Quantity quantity = inputQuantityWithValidation();
        table.addOrder(menu, quantity);
    }

    private Quantity inputQuantityWithValidation() {
        try {
            return new Quantity(InputView.inputQuantity());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputQuantityWithValidation();
        }
    }

    private Menu findByMenuWithValidation(final Menus menus) {
        try {
            return menus.findBy(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return findByMenuWithValidation(menus);
        }
    }


}
