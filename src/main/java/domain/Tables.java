package domain;

import java.util.List;

public class Tables {
    private static List<Table> tables;

    public Tables() {
        tables = TableRepository.tables();
    }

    public int size() {
        return tables.size();
    }

    public Table findBy(final int number) {
        return tables.stream()
                .filter(table -> table.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블 입니다."));
    }

    public Table findPayTableBy(final int number) {
        return tables.stream()
                .filter(table -> table.getNumber() == number && table.isOrdering())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결제 가능한 테이블이 아닙니다."));
    }

    public List<Table> getTables() {
        return tables;
    }
}
