package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("집합의 크기 확인 테스트")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("집합 객체 값 확인 테스트 1")
    void containsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("집합 객체 값 확인 테스트 2")
    void containsTest2() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
        assertThat(numbers.contains(5)).isFalse();
    }

    @DisplayName("집합 객체 값 확인 테스트 3, 중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContainsInputTest_ShouldReturnTrue(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("집합 객체 값 확인 테스트 4, 중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void isContainsInputTest_ShouldReturnFalse(Integer input) {
        assertFalse(numbers.contains(input));
    }
}
