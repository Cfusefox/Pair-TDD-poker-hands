package com.example;

import java.util.List;

public class Player {
    private List<String> pokerList;

    public Player(List<String> pokerList) {
        this.pokerList = pokerList;
    }

    public List<String> getPokerList() {
        return pokerList;
    }
}
