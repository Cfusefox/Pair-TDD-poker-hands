package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokerTest {
    @Test
    void should_return_black_win_when_given_not_repeat_card_and_not_flush() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3D", "5S", "9C", "KD"));
        Player player2 = new Player(Arrays.asList("2C", "3H", "4S", "9C", "AH"));

        // when
        String actual = compare.comparePoker(player1, player2);

        // then
        assertEquals("player2 wins. - with high card:Ace", actual);
    }
}
