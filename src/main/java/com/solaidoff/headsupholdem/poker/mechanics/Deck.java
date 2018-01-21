package com.solaidoff.headsupholdem.poker.mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck of cards to use for poker. The "top" of the deck is defined as index 0.
 * 
 * Initially a standard 52-card French deck
 * 
 * TODO future goal: add options like "jokers wild"
 */
public class Deck {
    private List<Card> drawDeck;
    private List<Card> discardPile;

    public static final int DECK_SIZE = 52;

    public Deck() {
        drawDeck = new ArrayList<Card>(DECK_SIZE);
        discardPile = new ArrayList<Card>();

        drawDeck.add(new Card(CardSuit.SPADES, CardRank.TWO));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.THREE));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.FOUR));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.FIVE));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.SIX));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.SEVEN));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.EIGHT));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.NINE));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.TEN));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.JACK));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.QUEEN));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.KING));
        drawDeck.add(new Card(CardSuit.SPADES, CardRank.ACE));

        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.FOUR));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.FIVE));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.SEVEN));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.NINE));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.JACK));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.QUEEN));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.KING));
        drawDeck.add(new Card(CardSuit.HEARTS, CardRank.ACE));

        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.TWO));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.THREE));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.FOUR));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.FIVE));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.SIX));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.SEVEN));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.EIGHT));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.NINE));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.TEN));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.JACK));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.QUEEN));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.KING));
        drawDeck.add(new Card(CardSuit.DIAMONDS, CardRank.ACE));

        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.TWO));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.THREE));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.FOUR));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.FIVE));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.SIX));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.SEVEN));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.EIGHT));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.NINE));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.TEN));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.JACK));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.QUEEN));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.KING));
        drawDeck.add(new Card(CardSuit.CLUBS, CardRank.ACE));

        shuffle();
    }

    /**
     * Reset the deck for a new game.
     * 
     * Any active and discarded cards should be added back to the deck, and then the card order randomized
     */
    public void shuffle() {
        // TODO reintegrate discards, cards from hands
        
        Collections.shuffle(drawDeck);
    }
    
    /**
     * Removes and returns the top card off of the deck.
     */
    public Card draw() {
        return drawDeck.remove(0);
    }
}