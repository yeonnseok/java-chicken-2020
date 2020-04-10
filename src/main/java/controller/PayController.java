package controller;

import domain.Payment;
import domain.PriceCalculator;
import domain.Table;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class PayController implements PosController {
    @Override
    public void run(final Tables tables) {
        Table table = findPayTableWithValidation(tables);

        OutputView.printOrderingMenus(table.getOrders().getOrders());
        OutputView.printPayProcessHeadMessage(table.getNumber());

        Payment payment = InputView.inputPayment();
        PriceCalculator priceCalculator = new PriceCalculator(table.getOrders(), payment);
        OutputView.printTotalPrice(priceCalculator.calculateTotalPrice());
        table.clear();
    }

    private Table findPayTableWithValidation(final Tables tables) {
        try {
            return tables.findPayTableBy(InputView.inputPayTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return findPayTableWithValidation(tables);
        }
    }
}
