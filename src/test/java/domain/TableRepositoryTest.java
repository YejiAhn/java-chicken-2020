package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableRepositoryTest {
    @Test
    @DisplayName("테이블 레포지토리 클래스에서 관리할 테이블 갯수가 정확히 나오는지")
    void tableNumber() {
        TableRepository repository = new TableRepository();
        List<Table> tables = repository.tables();
        assertThat(tables.size()).isEqualTo(6);
    }
}
