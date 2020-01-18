package com.thoughtworks;

public class FizzBuzzer {
    public static String FIZZ = "Fizz";
    public static String BUZZ = "Buzz";
    public static String WHIZZ = "Whizz";

    public static String fizzBuzz(final int index) {
        if (index < 1) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        Boolean isContains7 = isContains(index, "7");
        Boolean isContains5 = isContains(index, "5");
        Boolean isContains3 = isContains(index, "3");
        if (isContains3 && !isContains5) {
            return FizzBuzzer.FIZZ;
        }
        if (index % 3 == 0 && (!isContains7 || isContains5)) {
            result.append(FizzBuzzer.FIZZ);
        }
        if (index % 5 == 0 && !isContains7) {
            result.append(FizzBuzzer.BUZZ);
        }
        if (index % 7 == 0) {
            result.append(FizzBuzzer.WHIZZ);
        }
        return result.length() > 0 ? result.toString() : String.valueOf(index);
    }

    private static boolean isContains(final int index, String character) {
        return String.valueOf(index).indexOf(character) > -1;
    }
}
