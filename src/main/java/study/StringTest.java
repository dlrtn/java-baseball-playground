package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("a", "b");
        assertThat(actual).isEqualTo("bbc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");

        System.out.println(actual[0] + actual[1]);

        assertThat(actual).isEqualTo(new String[]{"1", "2"});
        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메소드 테스트, 성공")
    void chatAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo("a");
    }

    @Test
    @DisplayName("chatAt 메소드 테스트, 예외 발생")
    void chatAtExceptionTest() {
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index out of range");
    }
}
