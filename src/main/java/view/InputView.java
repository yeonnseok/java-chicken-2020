package view;

import domain.PosOption;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static PosOption inputPosOptionNumber() {
        OutputView.printMainScreen();
        try {
            return PosOption.findBy(inputIntegerValue());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputPosOptionNumber();
        }
    }

    public static int inputTableNumber() {
        OutputView.printInputTableNumberGuideMessage();
        return inputIntegerValue();
    }

    public static int inputMenuNumber() {
        OutputView.printInputMenuNumberGuideMessage();
        return inputIntegerValue();
    }

    public static int inputQuantity() {
        OutputView.printInputQuantityGuideMessage();
        return inputIntegerValue();
    }

    private static int inputIntegerValue() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력하세요.");
        }
    }
}
