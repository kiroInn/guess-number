package com.thoughtworks;

public class KeyManager {
    private int[] keys;

    public int[] getKeys() {
        if (null == keys) {
            return new int[] {1,2,3,4};
        }
        return keys;
    }
}
