package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokerTest {
    @Test
    void should_return_players_win_when_given_not_repeat_card_and_not_flush() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3D", "5S", "9C", "KD"));
        Player player2 = new Player(Arrays.asList("2C", "3H", "4S", "9C", "AH"));

        // when
        String actual = compare.comparePoker(player1, player2);

        // then
        assertEquals("player2 wins.", actual);
    }

    @Test
    void should_return_players_win_when_given_not_repeat_card_but_flush_and_max_card_equals() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3H", "5H", "9H", "KH"));
        Player player2 = new Player(Arrays.asList("2C", "3C", "5C", "9C", "KC"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("Tie.", actual);
    }

    @Test
    void should_return_players_win_when_given_not_repeat_card_but_flush_and_player2_max_card_bigger() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3H", "5H", "9H", "KH"));
        Player player2 = new Player(Arrays.asList("2C", "3C", "5C", "9C", "AC"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("player2 wins.", actual);
    }
}
