package numberbaseball;

import static java.lang.System.*;

public class Game {
    private final Computer computer;
    private final User user;
    private final Referee referee;

    Game() {
        this.computer = new Computer();
        this.user = new User();
        this.referee = new Referee();
    }

    void start() {
        int restart = 1;
        boolean isAnswer = false;
        while (restart != 2) {
            String[] computerNumbers = computer.makeNumbers();
            play(isAnswer, computerNumbers);
            restart = isRestart();
        }
    }

    private int isRestart() {
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return user.inputRestart();
    }

    private void play(boolean isAnswer, String[] computerNumbers) {
        while (!isAnswer) {
            String[] userNumbers = user.input();
            isAnswer = referee.compare(computerNumbers, userNumbers);
        }
    }

}
