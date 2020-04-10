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
}
