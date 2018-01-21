package com.solaidoff.headsupholdem.poker.mechanics;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }
    
    public String getShortName() {
        return "" + rank.getSymbol() + suit.getSymbol();
    }
    
    public String getLongName() {
        return rank.getNameSingular() + " of " + suit.getName();
    }

    @Override
    public int compareTo(Card otherCard) {
        return rank.compareTo(otherCard.getRank());
    }
}