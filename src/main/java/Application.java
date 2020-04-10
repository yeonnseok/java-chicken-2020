import domain.PosOption;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Tables tables = new Tables();
        PosOption posOption = InputView.inputPosOptionNumber();

        while (posOption.isNotTerminate()) {
            OutputView.printTables(tables.getTables());
            posOption.run(tables);
            posOption = InputView.inputPosOptionNumber();
        }
    }


}
