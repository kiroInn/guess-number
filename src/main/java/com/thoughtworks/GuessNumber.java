package com.thoughtworks;

import java.util.Arrays;

public class GuessNumber {
    private KeyManager keyManager;

    GuessNumber(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public String guess(final String args) {
        String[] input = args.split(" ");
        int[] numbers = new int[4];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int valueAndPositionCorrectCount = countValueAndPositionCorrect(numbers);
        int onlyValueCorrectCount = countOnlyValueCorrect(numbers);
        return String.join("", String.valueOf(valueAndPositionCorrectCount), "A", String.valueOf(onlyValueCorrectCount),
                "B");
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
}
