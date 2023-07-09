package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator("2 + 3 * 4 / 2");
    }

    @Test
    @DisplayName("계산기 테스트")
    void calculateTest() {
        assertThat(calculator.calculate()).isEqualTo(10);
    }
}
