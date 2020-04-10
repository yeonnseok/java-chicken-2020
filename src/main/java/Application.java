import domain.PosOption;
import domain.Table;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Tables tables = new Tables();
        PosOption posOption = InputView.inputPosOptionNumber();

        while (posOption.isNotTerminate()) {
            OutputView.printTables(tables.getTables());
            Table table = findByTableWithValidation(tables);
            posOption.run(table);
            posOption = InputView.inputPosOptionNumber();
        }
    }

    private static Table findByTableWithValidation(final Tables tables) {
        try {
            return tables.findBy(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return findByTableWithValidation(tables);
        }
    }
}
