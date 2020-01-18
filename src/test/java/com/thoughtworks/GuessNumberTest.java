package com.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberTest {

    @Test
    public void should_return_xA0b_when_given_x_match_number() {
        KeyManager keyStone = mock(KeyManager.class);
        when(keyStone.getKeys()).thenReturn(new int[]{1,2,3,4});
        GuessNumber guessNumber = new GuessNumber(keyStone);

        assertEquals("1A0B", guessNumber.guess("1 6 7 8"));
        assertEquals("1A0B", guessNumber.guess("5 2 7 8"));
        assertEquals("2A0B", guessNumber.guess("1 2 7 8"));
        assertEquals("3A0B", guessNumber.guess("1 2 7 4"));
        assertEquals("4A0B", guessNumber.guess("1 2 3 4"));
    }
}