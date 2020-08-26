package com.example;


import java.util.*;

public class Compare {
    public static final String PLAYER_1_WINS = "player1 wins.";
    public static final String PLAYER_2_WINS = "player2 wins.";
    public static final String TIE = "Tie.";
    public static final int PokerLength = 5;
    List<Character> numberList = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');
    List<String> typeList = Arrays.asList("High Card", "Pair", "Two Pairs", "Three of a kind",
            "Straight", "Flush", "Full House", "Four of a kind", "Straight flush");

    public String comparePoker(Player player1, Player player2) {
        List<String> pokerList1 = sortPokerList(player1.getPokerList());
        List<String> pokerList2 = sortPokerList(player2.getPokerList());
        String test1 = getTypfOfPoker(pokerList1);
        String test2 = getTypfOfPoker(pokerList2);
        if(getTypfOfPoker(pokerList1) == getTypfOfPoker(pokerList2)) {
            if(getTypfOfPoker(pokerList1) == "High Card" || getTypfOfPoker(pokerList1) == "Flush" ||
                    getTypfOfPoker(pokerList1) == "Straight flush" || getTypfOfPoker(pokerList1) == "Straight") {
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
            if(getTypfOfPoker(pokerList1) == "Pair") {
                LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
                LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();
                Character c1 = '0';
                Character c2 = '0';
                for (String poker: pokerList1) {
                    if(map1.get(poker.charAt(0)) == null) {
                        map1.put(poker.charAt(0), 1);
                    } else {
                        int number = map1.get(poker.charAt(0));
                        map1.put(poker.charAt(0), number + 1);
                    }
                }
                for (String poker: pokerList2) {
                    if(map2.get(poker.charAt(0)) == null) {
                        map2.put(poker.charAt(0), 1);
                    } else {
                        int number = map2.get(poker.charAt(0));
                        map2.put(poker.charAt(0), number + 1);
                    }
                }
                for (Character key: map1.keySet()) {
                    if(map1.get(key) == 2) {
                        c1 = key;
                    }
                }
                for (Character key: map2.keySet()) {
                    if(map2.get(key) == 2) {
                        c2 = key;
                    }
                }
                if(numberList.indexOf(c1) < numberList.indexOf(c2)) {
                    return "player2 wins.";
                }
                if(numberList.indexOf(c1) > numberList.indexOf(c2)) {
                    return "player1 wins.";
                }
                if(numberList.indexOf(c1) == numberList.indexOf(c2)) {
                    return "Tie.";
                }
            }
            if(getTypfOfPoker(pokerList1) == "Two Pairs") {
                List<Character> list1 = new ArrayList<>();
                List<Character> list2 = new ArrayList<>();
                LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
                LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();
                for (String poker: pokerList1) {
                    if(map1.get(poker.charAt(0)) == null) {
                        map1.put(poker.charAt(0), 1);
                    } else {
                        int number = map1.get(poker.charAt(0));
                        map1.put(poker.charAt(0), number + 1);
                    }
                }
                for (String poker: pokerList2) {
                    if(map2.get(poker.charAt(0)) == null) {
                        map2.put(poker.charAt(0), 1);
                    } else {
                        int number = map2.get(poker.charAt(0));
                        map2.put(poker.charAt(0), number + 1);
                    }
                }
                Character c1 = '0';
                Character c2 = '0';
                for (Character key: map1.keySet()) {
                    if(map1.get(key) == 2) {
                        list1.add(key);
                    }
                    if(map1.get(key) == 1) {
                        c1 = key;
                    }
                }
                for (Character key: map2.keySet()) {
                    if(map2.get(key) == 2) {
                        list2.add(key);
                    }
                    if(map2.get(key) == 1) {
                        c2 = key;
                    }
                }
                if(convertToInteger(list1.get(0)) > convertToInteger(list2.get(0))) {
                    return "player1 wins.";
                }
                if(convertToInteger(list1.get(0)) < convertToInteger(list2.get(0))) {
                    return "player2 wins.";
                }
                if(convertToInteger(list1.get(0)) == convertToInteger(list2.get(0))) {
                    if(convertToInteger(list1.get(1)) > convertToInteger(list2.get(1))) {
                        return "player1 wins.";
                    }
                    if(convertToInteger(list1.get(1)) < convertToInteger(list2.get(1))) {
                        return "player2 wins.";
                    }
                    if(convertToInteger(list1.get(1)) == convertToInteger(list2.get(1))) {
                        if(convertToInteger(c1) > convertToInteger(c2)) {
                            return "player1 wins.";
                        }
                        if(convertToInteger(c1) < convertToInteger(c2)) {
                            return "player2 wins.";
                        }
                        if(convertToInteger(c1) == convertToInteger(c2)) {
                            return "Tie.";
                        }
                    }
                }
            }
            if(getTypfOfPoker(pokerList1) == "Three of a Kind") {
                Character c1 = '0';
                Character c2 = '0';
                List<Character> list1 = new ArrayList<>();
                List<Character> list2 = new ArrayList<>();
                LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
                LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();
                for (String poker: pokerList1) {
                    if(map1.get(poker.charAt(0)) == null) {
                        map1.put(poker.charAt(0), 1);
                    } else {
                        int number = map1.get(poker.charAt(0));
                        map1.put(poker.charAt(0), number + 1);
                    }
                }
                for (String poker: pokerList2) {
                    if(map2.get(poker.charAt(0)) == null) {
                        map2.put(poker.charAt(0), 1);
                    } else {
                        int number = map2.get(poker.charAt(0));
                        map2.put(poker.charAt(0), number + 1);
                    }
                }
                for (Character key: map1.keySet()) {
                    if(map1.get(key) == 3) {
                        c1 = key;
                    }
                    if(map1.get(key) == 1) {
                        list1.add(key);
                    }
                }
                for (Character key: map2.keySet()) {
                    if(map2.get(key) == 3) {
                        c2 = key;
                    }
                    if(map2.get(key) == 1) {
                        list2.add(key);
                    }
                }
                if(convertToInteger(c1) > convertToInteger(c2)) {
                    return PLAYER_1_WINS;
                }
                if(convertToInteger(c1) < convertToInteger(c2)) {
                    return PLAYER_2_WINS;
                }
            }
            if(getTypfOfPoker(pokerList1) == "Full House") {
                Character three1 = '0';
                Character three2 = '0';
                Character two1 = '0';
                Character two2 = '0';
                LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
                LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();
                for (String poker: pokerList1) {
                    if(map1.get(poker.charAt(0)) == null) {
                        map1.put(poker.charAt(0), 1);
                    } else {
                        int number = map1.get(poker.charAt(0));
                        map1.put(poker.charAt(0), number + 1);
                    }
                }
                for (String poker: pokerList2) {
                    if(map2.get(poker.charAt(0)) == null) {
                        map2.put(poker.charAt(0), 1);
                    } else {
                        int number = map2.get(poker.charAt(0));
                        map2.put(poker.charAt(0), number + 1);
                    }
                }
                for (Character key: map1.keySet()) {
                    if(map1.get(key) == 3) {
                        three1 = key;
                    }
                    if(map1.get(key) == 2) {
                        two1 = key;
                    }
                }
                for (Character key: map2.keySet()) {
                    if(map2.get(key) == 3) {
                        three2 = key;
                    }
                    if(map2.get(key) == 2) {
                        two2 = key;
                    }
                }
                if(convertToInteger(three1) > convertToInteger(three2)) {
                    return PLAYER_1_WINS;
                }
                if(convertToInteger(three1) < convertToInteger(three2)) {
                    return PLAYER_2_WINS;
                }
            }
        }
        return null;

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

    protected String getTypfOfPoker(List<String> pokerList) {
        LinkedHashMap<Character, Integer> pokerNumberMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> pokerMap = new LinkedHashMap<>();
        for (String poker: pokerList) {
            if(pokerMap.get(poker) == null) {
                pokerMap.put(poker, 1);
            } else {
                int number = pokerMap.get(poker);
                pokerMap.put(poker, number + 1);
            }
        }
        for (String poker: pokerList) {
            if(pokerNumberMap.get(poker.charAt(0)) == null) {
                pokerNumberMap.put(poker.charAt(0), 1);
            } else {
                int number = pokerNumberMap.get(poker.charAt(0));
                pokerNumberMap.put(poker.charAt(0), number + 1);
            }
        }
        if(pokerNumberMap.size() == 5) {
            Character decor = pokerList.get(0).charAt(1);
            Boolean isFlush = true;
            for(String key: pokerMap.keySet()) {
                if(key.charAt(1) != decor) {
                    isFlush = false;
                }
            }
            Boolean isStraight = true;
            Integer initNumber = 0;
            //todo refactor
            for(String key: pokerMap.keySet()) {
                initNumber = convertToInteger(key.charAt(0));
                break;
            }
            for(Character key: pokerNumberMap.keySet()) {
                if(convertToInteger(key) == initNumber) {
                    initNumber -= 1;
                } else {
                    isStraight = false;
                }
            }
            if(isStraight && isFlush) {
                return "Straight flush";
            }
            if(isStraight && !isFlush) {
                return "Straight";
            }
            if(!isStraight && isFlush) {
                return "Flush";
            }
            if(!isStraight && !isFlush) {
                return "High Card";
            }

        }
        if(pokerNumberMap.size() == 4) {
            return "Pair";
        }
        if(pokerNumberMap.size() == 3){
            for (int value: pokerNumberMap.values()) {
                if(value == 3)
                {
                    return "Three of a Kind";
                }
                if(value == 2)
                {
                    return "Two Pairs";
                }
            }
        }
        if(pokerNumberMap.size() ==2) {
            for (int value: pokerNumberMap.values()) {
                if(value == 4)
                {
                    return "Four of a kind";
                }
                if(value == 3)
                {
                    return "Full House";
                }
            }
        }
        return null;
    }

    private Integer convertToInteger(Character c) {
        if(c == 'T'){
            return 10;
        }else  if(c == 'J'){
            return 11;
        }else if(c == 'Q'){
            return 12;
        }else if(c == 'K'){
            return 13;
        }else{
            return c - '0';
        }
    }

}
