package com.thoughtworks;

public class GuessNumber {
    private KeyManager keyManager;

    GuessNumber(KeyManager keyManager){
        this.keyManager = keyManager;
    }

    public String guess(final String args) {
        String[] input = args.split(" ");
        int[] numbers = new int[4];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int correctCount = countValueAndPositionCorrect(numbers);
        return String.join("", String.valueOf(correctCount), "A0B");
    }

    private int countValueAndPositionCorrect(int[] numbers) {
        int[] keyManager = this.keyManager.getKeys();
        int matchCount = 0;
        for(int i=0; i< keyManager.length; i++){
            matchCount += keyManager[i] == numbers[i] ? 1 : 0;
        }
        return matchCount;
    }
}
