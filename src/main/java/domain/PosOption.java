package domain;

import controller.OrderController;
import controller.PayController;
import controller.PosController;
import controller.TerminateController;

import java.util.Arrays;

public enum PosOption {
    ORDER(1, new OrderController()),
    PAY(2, new PayController()),
    TERMINATE(3, new TerminateController());

    private final int number;
    private final PosController posController;

    PosOption(final int number, final PosController posController) {
        this.number = number;
        this.posController = posController;
    }

    public static PosOption findBy(final int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 옵션입니다."));
    }

    public boolean isNotTerminate() {
        return this != TERMINATE;
    }

    public void run(final Tables tables) {
        posController.run(tables);
    }
}
