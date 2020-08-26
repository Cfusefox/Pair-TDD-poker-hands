package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Compare {
    public static final String PLAYER_1_WINS = "player1 wins.";
    public static final String PLAYER_2_WINS = "player2 wins.";
    public static final String TIE = "Tie.";
    public static final int PokerLength = 5;
    List<Character> numberList = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');

    public String comparePoker(Player player1, Player player2) {
        List<String> pokerList1 = sortPokerList(player1.getPokerList());
        List<String> pokerList2 = sortPokerList(player2.getPokerList());
        for (int i = 0; i < PokerLength; i++) {
            if(numberList.indexOf(pokerList1.get(i).charAt(0)) > numberList.indexOf(pokerList2.get(i).charAt(0))) {
                return PLAYER_1_WINS;
            }
            if(numberList.indexOf(pokerList1.get(i).charAt(0)) < numberList.indexOf(pokerList2.get(i).charAt(0))){
                return PLAYER_2_WINS;
            }
        }
        return TIE;
    }

    private List<String> sortPokerList(List<String> pokerList) {
        ArrayList<Poker> pokerObjectList = new ArrayList<>();
        List<String> sortedPokerList = new ArrayList<>();
        for (String poker: pokerList) {
            pokerObjectList.add(new Poker(poker, numberList.indexOf(poker.charAt(0))));
        }
        Collections.sort(pokerObjectList);
        for (Poker poker: pokerObjectList) {
            sortedPokerList.add(poker.getPokerString());
        }
        return sortedPokerList;
    }


}
