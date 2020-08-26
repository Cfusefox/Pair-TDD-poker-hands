package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokerTest {
    @Test
    void should_return_player2_win_when_compare_given_not_repeat_card_and_not_flush() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3D", "9C", "KD", "5S"));
        Player player2 = new Player(Arrays.asList("2C", "3H", "4S", "9C", "AH"));

        // when
        String actual = compare.comparePoker(player1, player2);

        // then
        assertEquals("player2 wins.", actual);
    }

    @Test
    void should_return_player1_win_when_compare_given_not_repeat_card_and_not_flush_but_max_equals() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3D", "5S", "9C", "KD"));
        Player player2 = new Player(Arrays.asList("2C", "3H", "5S", "8C", "KH"));

        // when
        String actual = compare.comparePoker(player1, player2);

        // then
        assertEquals("player1 wins.", actual);
    }

    @Test
    void should_return_player1_win_when_compare_given_not_repeat_card_and_not_flush_and_card_equals() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3D", "5S", "9C", "KD"));
        Player player2 = new Player(Arrays.asList("2C", "3H", "5S", "9C", "KH"));

        // when
        String actual = compare.comparePoker(player1, player2);

        // then
        assertEquals("Tie.", actual);
    }


    @Test
    void should_return_tie_when_compare_given_not_repeat_card_but_flush_and_max_card_equals() {
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
    void should_return_player2_win_when_compare_given_not_repeat_card_but_flush_and_player2_max_card_bigger() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "3H", "5H", "9H", "KH"));
        Player player2 = new Player(Arrays.asList("2C", "3C", "5C", "9C", "AC"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("player2 wins.", actual);
    }

    @Test
    void should_player1_wins_when_compare_given_pair_equals() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "2S", "5H", "9H", "KH"));
        Player player2 = new Player(Arrays.asList("2C", "2D", "5C", "9C", "AC"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("Tie.", actual);
    }

    @Test
    void should_player2_wins_when_compare_given_straight() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("3H", "4D", "5S", "6C", "7D"));
        Player player2 = new Player(Arrays.asList("4D", "5S", "6C", "7D", "8S"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("player2 wins.", actual);
    }

    @Test
    void should_player2_wins_when_compare_given_two_pairs() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("3H", "3D", "5S", "5H", "7D"));
        Player player2 = new Player(Arrays.asList("4D", "4S", "6C", "6D", "8S"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("player2 wins.", actual);
    }

    @Test
    void should_tie_when_compare_given_two_pairs_and_equals() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("3H", "3D", "5S", "5H", "7D"));
        Player player2 = new Player(Arrays.asList("3C", "3S", "5C", "5D", "7S"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("Tie.", actual);
    }

    @Test
    void should_player2_win_when_compare_given_three_of_a_kind() {
        // given
        Compare compare = new Compare();
        Player player1 = new Player(Arrays.asList("2H", "2D", "2S", "5H", "7D"));
        Player player2 = new Player(Arrays.asList("3C", "3S", "3H", "5D", "7S"));
        // when
        String actual = compare.comparePoker(player1,player2);

        // then
        assertEquals("player2 wins.", actual);
    }

}
