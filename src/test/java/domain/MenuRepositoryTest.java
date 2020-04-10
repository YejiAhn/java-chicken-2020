package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuRepositoryTest {
    @Test
    @DisplayName("테이블 레포지토리 클래스에서 관리할 테이블 갯수가 정확히 나오는지")
    void menuNumber() {
        MenuRepository repository = new MenuRepository();
        List<Menu> menus = repository.menus();
        assertThat(menus.size()).isEqualTo(8);
    }
}
