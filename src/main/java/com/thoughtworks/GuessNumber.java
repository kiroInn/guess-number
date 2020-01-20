package com.thoughtworks;

import java.util.Arrays;

public class GuessNumber {
    private static String ERROR_MSG = "Wrong Input, input again";
    private KeyManager keyManager;
    private String args;

    GuessNumber(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public String guess(String args) {
        this.setArgs(args);
        if (!this.isValid()) {
            return ERROR_MSG;
        }
        int[] numbers = parseNumbers();
        int valueAndPositionCorrectCount = countValueAndPositionCorrect(numbers);
        int onlyValueCorrectCount = countOnlyValueCorrect(numbers);
        return String.join("", String.valueOf(valueAndPositionCorrectCount), "A", String.valueOf(onlyValueCorrectCount),
                "B");
    }

    private int[] parseNumbers() {
        if (this.isValid()) {
            return Arrays.stream(this.args.split(" ")).mapToInt(number -> Integer.valueOf(number)).toArray();
        }
        return new int[] {};
    }

    private boolean isValid() {
        String[] numbers = this.args.split(" ");
        return Utils.isNumeric(numbers) && !Utils.isDuplicate(numbers);
    }

    private int countOnlyValueCorrect(int[] numbers) {
        int[] keys = this.keyManager.getKeys();
        int matchCount = 0;
        for (int i = 0; i < keys.length; i++) {
            int currentNumber = keys[i];
            matchCount += (keys[i] == numbers[i]) ? 0
                    : Arrays.stream(numbers).anyMatch(number -> number == currentNumber) ? 1 : 0;
        }
        return matchCount;
    }

    private int countValueAndPositionCorrect(int[] numbers) {
        int[] keys = this.keyManager.getKeys();
        int matchCount = 0;
        for (int i = 0; i < keys.length; i++) {
            matchCount += keys[i] == numbers[i] ? 1 : 0;
        }
        return matchCount;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

}
