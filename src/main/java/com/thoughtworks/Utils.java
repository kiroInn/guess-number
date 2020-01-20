package com.thoughtworks;

import java.util.Arrays;

public class Utils {

	public static boolean isNumeric(String value) {
        return value != null && value.matches("[-+]?\\d*\\.?\\d+");  
    }
    
    public static boolean isNumeric(String[] numbers){
        if(null == numbers){
            return false;
        }
        return Arrays.stream(numbers).allMatch(value -> isNumeric(value));
    }

	public static boolean isDuplicate(String[] numbers) {
        if(null == numbers){
            return false;
        }
		return numbers.length != Arrays.stream(numbers).distinct().count();
	}

}
