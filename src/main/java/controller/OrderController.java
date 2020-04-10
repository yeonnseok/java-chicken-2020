package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class OrderController implements PosController {
    private Menus menus = new Menus();

    @Override
    public void run(final Tables tables) {
        Table table = findOrderingTableWithValidation(tables);

        OutputView.printMenus(menus.getMenus());
        Menu menu = findOrderingMenuWithValidation(menus);

        Quantity quantity = inputQuantityWithValidation();
        table.addOrder(menu, quantity);
    }

    private static Table findOrderingTableWithValidation(final Tables tables) {
        try {
            return tables.findBy(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return findOrderingTableWithValidation(tables);
        }
    }

    private Menu findOrderingMenuWithValidation(final Menus menus) {
        try {
            return menus.findBy(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return findOrderingMenuWithValidation(menus);
        }
    }

    private Quantity inputQuantityWithValidation() {
        try {
            return new Quantity(InputView.inputQuantity());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputQuantityWithValidation();
        }
    }


}
