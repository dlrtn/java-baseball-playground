package study;

import java.util.Arrays;

public class Calculator {
    private final String[] inputArr;

    public Calculator(String input) {
        this.inputArr = input.split(" ");
    }

    public double calculate() {
        double result = Integer.parseInt(inputArr[0]);

        Arrays.stream(inputArr).filter(s -> s.matches("[+-/*]")).forEach(System.out::println);

        for (int i = 1; i < inputArr.length; i += 2) {
            String operator = inputArr[i];
            int operand = Integer.parseInt(inputArr[i + 1]);

            switch (operator) {
                case "+":
                    result = add(result, operand);
                    break;
                case "-":
                    result = subtract(result, operand);
                    break;
                case "*":
                    result = multiply(result, operand);
                    break;
                case "/":
                    result = divide(result, operand);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
        return result;
    }

    private double add(double firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    private double subtract(double firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    private double multiply(double firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    private double divide(double firstOperand, int secondOperand) {
        checkIsSecondOperandZero(secondOperand);
        return firstOperand / secondOperand;
    }

    private void checkIsSecondOperandZero(int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }
}
