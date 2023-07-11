package numberbaseball;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class Referee {
    public boolean compare(String[] computerNumbers, String[] userNumbers) {
        int strike = calculateStrike(computerNumbers, userNumbers);
        int ball = calculateBall(computerNumbers, userNumbers) - strike;

        return judge(strike, ball);
    }

    private int calculateStrike(String[] computerNumbers, String[] userNumbers) {
        return (int) IntStream.range(0, computerNumbers.length)
                .filter(i -> computerNumbers[i].equals(userNumbers[i]))
                .count();
    }

    private int calculateBall(String[] computerNumbers, String[] userNumbers) {
        return (int) IntStream.range(0, userNumbers.length)
                .filter(i -> Arrays.asList(computerNumbers).contains(userNumbers[i]))
                .count();
    }

    private boolean judge(int strike, int ball) {
        if (strike == 3) {
            out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        out.printf("%d 스트라이크, %d 볼%n", strike, ball);
        return false;
    }
}
