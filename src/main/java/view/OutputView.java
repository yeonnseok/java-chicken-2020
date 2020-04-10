package view;

import domain.Menu;
import domain.Quantity;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERING_BOTTOM_LINE = "└ ₩ ┘";


    public static void printMainScreen() {
        final String message = "## 메인화면 \n" +
                "1 - 주문등록\n" +
                "2 - 결제하기\n" +
                "3 - 프로그램 종료\n";
        System.out.println(message);
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(size);
        printTableNumbers(tables);
        for (Table table : tables) {
            if (table.isOrdering()) {
                System.out.print(ORDERING_BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }

    public static void printInputTableNumberGuideMessage() {
        System.out.println("## 주문할 테이블을 선택하세요.");
    }

    public static void printInputMenuNumberGuideMessage() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
    }

    public static void printInputQuantityGuideMessage() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
    }

    public static void printInputPayTableNumberGuideMessage() {
        System.out.println("## 결제할 테이블을 선택하세요.");
    }

    public static void printOrderingMenus(final Map<Menu, Quantity> orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Menu menu : orders.keySet()) {
            System.out.println(String.format("%s %d %d",
                    menu.getName(), orders.get(menu).getQuantity(), menu.getPrice()));
        }
    }

    public static void printPayProcessHeadMessage(final int number) {
        System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", number));
        System.out.println("## 신용카드는 1번, 현금은 2번");
    }

    public static void printTotalPrice(final double totalPrice) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(String.format("%d원", (int) totalPrice));
    }
}
