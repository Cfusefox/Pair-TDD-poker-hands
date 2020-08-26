package com.example;

import java.util.Arrays;
import java.util.List;

public class Compare {
    public static final String PLAYER_1_WINS = "player1 wins.";
    public static final String PLAYER_2_WINS = "player2 wins.";
    public static final String TIE = "Tie.";

    public String comparePoker(Player player1, Player player2) {
        List<Character> numberList = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
        int MaxCardIndex1 = 0;
        int MaxCardIndex2 = 0;
        List<String> pokerList1 = player1.getPokerList();
        List<String> pokerList2 = player2.getPokerList();
        for (String pokerCard : pokerList1) {
            int test = numberList.indexOf(pokerCard.charAt(0));
            if (numberList.indexOf(pokerCard.charAt(0)) >= MaxCardIndex1) {
                MaxCardIndex1 = numberList.indexOf(pokerCard.charAt(0));
            }
        }
        for (String pokerCard : pokerList2) {
            if (numberList.indexOf(pokerCard.charAt(0)) >= MaxCardIndex2) {
                MaxCardIndex2 = numberList.indexOf(pokerCard.charAt(0));
            }
        }

        if (MaxCardIndex1 > MaxCardIndex2) {
            return PLAYER_1_WINS;
        } else if (MaxCardIndex1 < MaxCardIndex2) {
            return PLAYER_2_WINS;
        } else {
            return TIE;
        }
    }
}
