package numberbaseball;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class User {
    public String[] input() {
        Scanner input = new Scanner(in);
        String userNumbers;
        do {
            out.println("3자리 숫자를 입력하세요.");
            userNumbers = input.next();
        } while (!isValidInput(userNumbers));

        return userNumbers.split("");
    }

    private boolean isValidInput(String input) {
        return input.length() == 3;
    }

    public int inputRestart() {
        Scanner input = new Scanner(in);

        return input.nextInt();
    }
}
