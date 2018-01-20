package com.solaidoff.headsupholdem.poker.mechanics.hands;

import java.util.Collection;

import com.solaidoff.headsupholdem.poker.mechanics.Card;

/**
 * Generically, a "Hand" is just a group of cards. It can mean different things in different games, or even within a game, depending on the situation.
 * 
 * In straight poker, it may just refer to the five cards dealt to the player.
 * 
 * In Texas Hold 'Em, it can be the two hole cards a player is dealt at the beginning of a round, or the way the player combines those hole cards with community cards at showdown.
 * 
 * In stud variants, it may refer to the seven cards dealt to the player, some of which are face-up and some of which are face-down.
 * 
 * In pineapple and draw variants, it may refer to all cards dealt to a player or just those not yet discarded.
 * 
 * In Open Face Chinese, it may refer to all cards dealt to a player or any of the three individual sub-groupings formed by the player from the initial 13 cards.
 */
public abstract class Hand {
    public static final int HAND_SIZE_COMPLETE = 5;

    Collection<Card> cards;
}
