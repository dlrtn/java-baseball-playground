package numberbaseball;

import java.util.HashSet;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Computer {
    private String[] numbers;
    private final HashSet<String> numberSet = new HashSet<>();

    public String[] makeNumbers() {
        numbers = new String[3];
        generateUniqueNumbers();

        return numbers;
    }

    private void generateUniqueNumbers() {
        IntStream.range(0, numbers.length)
                .forEach(i -> numbers[i] = generateUniqueNumber());
    }

    private String generateUniqueNumber() {
        String number;
        do {
            number = String.valueOf((int) (random() * 9 + 1));
        } while (numberSet.contains(number));

        numberSet.add(number);
        return number;
    }
}
