package com.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberTest {

    @Test
    public void should_return_xA0B_when_given_x_match_number() {
        KeyManager keyStone = mock(KeyManager.class);
        when(keyStone.getKeys()).thenReturn(new int[]{1,2,3,4});
        GuessNumber guessNumber = new GuessNumber(keyStone);

        assertEquals("1A0B", guessNumber.guess("1 6 7 8"));
        assertEquals("1A0B", guessNumber.guess("5 2 7 8"));
        assertEquals("2A0B", guessNumber.guess("1 2 7 8"));
        assertEquals("3A0B", guessNumber.guess("1 2 7 4"));
        assertEquals("4A0B", guessNumber.guess("1 2 3 4"));
    }

    @Test
    public void should_return_value_correct_position_err_when_given_x_match_number() {
        KeyManager keyStone = mock(KeyManager.class);
        when(keyStone.getKeys()).thenReturn(new int[]{1,2,3,4});
        GuessNumber guessNumber = new GuessNumber(keyStone);

        assertEquals("0A4B", guessNumber.guess("4 3 2 1"));
        assertEquals("1A3B", guessNumber.guess("1 4 2 3"));
        assertEquals("0A1B", guessNumber.guess("6 8 1 9"));
    }
}