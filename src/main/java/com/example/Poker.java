package com.example;

public class Poker implements Comparable<Poker>{
    private String pokerString;
    private int pokerIndex;

    public Poker(String pokerString, int pokerIndex) {
        this.pokerString = pokerString;
        this.pokerIndex = pokerIndex;
    }

    public String getPokerString() {
        return pokerString;
    }

    public int getPokerIndex() {
        return pokerIndex;
    }

    @Override
    public int compareTo(Poker poker) {
        return  poker.pokerIndex - this.pokerIndex;
    }

}
