package com.solaidoff.headsupholdem.poker.mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck of cards to use for poker.
 * 
 * Initially a standard 52-card French deck
 * 
 * TODO future goal: add options like "jokers wild"
 */
public class Deck {
    private List<Card> deck;

    public static final int DECK_SIZE = 52;

    public Deck() {
        deck = new ArrayList<Card>(DECK_SIZE);

        deck.add(new Card(CardSuit.SPADES, CardRank.TWO));
        deck.add(new Card(CardSuit.SPADES, CardRank.THREE));
        deck.add(new Card(CardSuit.SPADES, CardRank.FOUR));
        deck.add(new Card(CardSuit.SPADES, CardRank.FIVE));
        deck.add(new Card(CardSuit.SPADES, CardRank.SIX));
        deck.add(new Card(CardSuit.SPADES, CardRank.SEVEN));
        deck.add(new Card(CardSuit.SPADES, CardRank.EIGHT));
        deck.add(new Card(CardSuit.SPADES, CardRank.NINE));
        deck.add(new Card(CardSuit.SPADES, CardRank.TEN));
        deck.add(new Card(CardSuit.SPADES, CardRank.JACK));
        deck.add(new Card(CardSuit.SPADES, CardRank.QUEEN));
        deck.add(new Card(CardSuit.SPADES, CardRank.KING));
        deck.add(new Card(CardSuit.SPADES, CardRank.ACE));

        deck.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        deck.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        deck.add(new Card(CardSuit.HEARTS, CardRank.FOUR));
        deck.add(new Card(CardSuit.HEARTS, CardRank.FIVE));
        deck.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        deck.add(new Card(CardSuit.HEARTS, CardRank.SEVEN));
        deck.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        deck.add(new Card(CardSuit.HEARTS, CardRank.NINE));
        deck.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        deck.add(new Card(CardSuit.HEARTS, CardRank.JACK));
        deck.add(new Card(CardSuit.HEARTS, CardRank.QUEEN));
        deck.add(new Card(CardSuit.HEARTS, CardRank.KING));
        deck.add(new Card(CardSuit.HEARTS, CardRank.ACE));

        deck.add(new Card(CardSuit.DIAMONDS, CardRank.TWO));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.THREE));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.FOUR));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.FIVE));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.SIX));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.SEVEN));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.EIGHT));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.NINE));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.TEN));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.JACK));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.QUEEN));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.KING));
        deck.add(new Card(CardSuit.DIAMONDS, CardRank.ACE));

        deck.add(new Card(CardSuit.CLUBS, CardRank.TWO));
        deck.add(new Card(CardSuit.CLUBS, CardRank.THREE));
        deck.add(new Card(CardSuit.CLUBS, CardRank.FOUR));
        deck.add(new Card(CardSuit.CLUBS, CardRank.FIVE));
        deck.add(new Card(CardSuit.CLUBS, CardRank.SIX));
        deck.add(new Card(CardSuit.CLUBS, CardRank.SEVEN));
        deck.add(new Card(CardSuit.CLUBS, CardRank.EIGHT));
        deck.add(new Card(CardSuit.CLUBS, CardRank.NINE));
        deck.add(new Card(CardSuit.CLUBS, CardRank.TEN));
        deck.add(new Card(CardSuit.CLUBS, CardRank.JACK));
        deck.add(new Card(CardSuit.CLUBS, CardRank.QUEEN));
        deck.add(new Card(CardSuit.CLUBS, CardRank.KING));
        deck.add(new Card(CardSuit.CLUBS, CardRank.ACE));

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}