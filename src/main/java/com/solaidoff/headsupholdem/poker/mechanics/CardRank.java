package com.solaidoff.headsupholdem.poker.mechanics;

public enum CardRank {
    //@formatter:off
    TWO     ('2', 2, "deuce", "deuces"),
    THREE   ('3', 3, "trey", "treys"),
    FOUR    ('4', 4, "four", "fours"),
    FIVE    ('5', 5, "five", "fives"),
    SIX     ('6', 6, "six", "sixes"),
    SEVEN   ('7', 7, "seven", "sevens"),
    EIGHT   ('8', 8, "eight", "eights"),
    NINE    ('9', 9, "nine", "nines"),
    TEN     ('T', 10, "ten", "tens"),
    JACK    ('J', 11, "jack", "jacks"),
    QUEEN   ('Q', 12, "queen", "queens"),
    KING    ('K', 13, "king", "kings"),
    ACE     ('A', 14, "ace", "aces"); // TODO: support case where aces are low, as in A-5 straights and some lowball games
    //@formatter:on

    private char symbol;
    private int value;
    private String nameSingular;
    private String namePlural;

    private CardRank(char symbol, int value, String nameSingular, String namePlural) {
        this.symbol = symbol;
        this.value = value;
        this.nameSingular = nameSingular;
        this.namePlural = namePlural;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getValue() {
        return this.value;
    }

    public String getNameSingular() {
        return this.nameSingular;
    }

    public String getNamePlural() {
        return this.namePlural;
    }
}