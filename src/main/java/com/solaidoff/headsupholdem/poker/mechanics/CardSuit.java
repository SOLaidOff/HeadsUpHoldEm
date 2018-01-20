package com.solaidoff.headsupholdem.poker.mechanics;

public enum CardSuit {
    //@formatter:off
    SPADES     ('s', "spades"),
    HEARTS     ('h', "hearts"),
    DIAMONDS   ('d', "diamonds"),
    CLUBS      ('c', "clubs");
    //@formatter:on

    private char symbol;
    private String name;

    private CardSuit(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}