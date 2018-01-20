package com.solaidoff.headsupholdem.poker.mechanics.hands;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.solaidoff.headsupholdem.poker.mechanics.Card;
import com.solaidoff.headsupholdem.poker.mechanics.CardRank;
import com.solaidoff.headsupholdem.poker.mechanics.HandRank;

/**
 * An EvaluatedHand represents a standard, complete, five-card poker hand. Enough information is present for its strength/value to be determined. This determination is made as part of the object
 * creation process. The hand may be compared to other complete hands to determine their <em>relative</em> strength.
 */
public class EvaluatedHand extends Hand implements Comparable<EvaluatedHand> {
    private HandRank handRank;
    private CardRank[] tiebreakerCardRanks;

    private Card[] cards;

    private boolean[] pairsFound;

    {
        cards = new Card[Hand.HAND_SIZE_COMPLETE];
    }

    public EvaluatedHand(Collection<Card> cardsCollection) {
        // TODO: assemble the array cards from the incoming collection cards
        cards = cardsCollection.toArray(cards); // FIXME temporary hack

        sort();

        evaluate();
    }

    /**
     * Helper method for setting up the object. Sorts the cards in the hand from highest (A) to lowest (2).
     * 
     * TODO: streamline this... currently sort of too complicated for such a simple task
     * 
     * TODO: reconsider this method if and when expanding support to lowball games
     */
    private void sort() {
        Arrays.sort(cards);
        List<Card> cardsAsList = Arrays.asList(cards);
        Collections.reverse(cardsAsList);
        cards = cardsAsList.toArray(cards);
    }

    /**
     * This method is the heart of the setup, and possibly of the whole class. It's the one that actually looks at the cards and determines the strength of the hand.
     */
    private void evaluate() {
        //@formatter:off
        /*
         * There are probably a lot of different ways to do this. Based on these numbers: 
         * 
         * POSSIBLE HANDS         NO PAIR    AT LEAST PAIR    AT LEAST THREE OF A KIND    PROB.
         * Nothing (high card)       X                                                    50%
         * One pair                                X                                      42%
         * Two pair                                X                                      4.8%
         * Three of a kind                         X                     X                2.1%
         * Straight                  X                                                    0.4%
         * Flush                     X                                                    0.2%
         * Full house                              X                     X                0.1%
         * Quads                                   X                     X                ~0%
         * Straight flush            X                                                    ~0%
         *                          ~51%          ~49%                  ~2.2%
         * 
         * (Probabilities from http://www.math.hawaii.edu/~ramsey/Probability/PokerHands.html, 2016-Aug-20)
         * 
         * hands are split about evenly between those containing no paired cards at all and those that do have duplicates. So, that will be the first "decision point" in the algorithm here.
         * 
         * If no pair is found, the next step is fairly straightforward; check for straights and flushes. If both, it's a straight flush; if neither, it's a high card situation. Otherwise, it's just a
         * straight or just a flush. The tiebreaker is the high card (or all the cards, in a high card situation).
         * 
         * If a pair IS fouund, it's a little more complicated. The POSITIONS of pairs can actually be used to identify hand type. For example, if numbers represent whether a pair exists around a
         * given position:
         * 
         * A J J T 4     (pair of jacks)
         *  0 1 0 0      (location of pair)
         * 
         * 8 5 5 5 5     (quad fives)
         *  0 1 1 1      (location of pairs)
         *  
         * The above examples (and more) are represented in more condensed form below:
         * 
         * xyyzw > 0100 (one pair)
         * xxyzz > 1001 (two pair)
         * xxxyz > 1100 (three of a kind)
         * xyyyy > 0111 (quads)
         * xxyyy > 1011 (full house)
         */
        //@formatter:on

        // FIXME TODO

        findPairs();

        if (this.isUnpaired()) {
            evaluateUnpaired();
        } else {
            evaluatePairOrMore();
        }
    }

    private void findPairs() {
        pairsFound = new boolean[cards.length - 1];

        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].compareTo(cards[i + 1]) == 0) {
                pairsFound[i] = true;
            } else {
                pairsFound[i] = false;
            }
        }
    }

    private boolean isUnpaired() {
        for (boolean b : pairsFound) {
            if (b == true)
                return false;
        }

        return true;
    }

    private void evaluateUnpaired() {
        boolean straight = isStraight();
        boolean flush = isFlush();

        tiebreakerCardRanks = new CardRank[5];

        // Account for A-5-4-3-2 straight special case
        if (straight && cards[4].getValue() == 2) {
            tiebreakerCardRanks[0] = cards[1].getRank();
            tiebreakerCardRanks[1] = cards[2].getRank();
            tiebreakerCardRanks[2] = cards[3].getRank();
            tiebreakerCardRanks[3] = cards[4].getRank();
            tiebreakerCardRanks[4] = cards[0].getRank(); // FIXME ace is correctly saved as low but the system still represents it as high
        } else {
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[1].getRank();
            tiebreakerCardRanks[2] = cards[2].getRank();
            tiebreakerCardRanks[3] = cards[3].getRank();
            tiebreakerCardRanks[4] = cards[4].getRank();
        }

        if (straight && flush) {
            handRank = HandRank.STRAIGHT_FLUSH;
        } else if (flush) {
            handRank = HandRank.FLUSH;
        } else if (straight) {
            handRank = HandRank.STRAIGHT;
        } else {
            handRank = HandRank.HIGH_CARD;
        }
    }

    private boolean isStraight() {
        // Check for special case of A-2-3-4-5 straight
        // Would be represented here as A-5-4-3-2
        // Precondition: hand is sorted and contains no pairs
        if (cards[0].getValue() == 14 && cards[1].getValue() == 5) {
            return true;
        }

        // Non-special cases
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getValue() != cards[i + 1].getValue() + 1) {
                return false;
            }
        }

        return true;
    }

    private boolean isFlush() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (!((cards[i].getSuit()).equals(cards[i + 1].getSuit()))) {
                return false;
            }
        }
        return true;
    }

    private void evaluatePairOrMore() {
        // Order matters in the following section!
        // Could be made safer with additional checks in the if statements
        // TODO: figure out something better than a giant chain of ifs

        // Quads with lower kicker
        if (pairsFound[0] && pairsFound[1] && pairsFound[2]) {
            handRank = HandRank.FOUR_OF_A_KIND;

            tiebreakerCardRanks = new CardRank[2];
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[4].getRank();

            return;
        }

        // Quads with higher kicker
        if (pairsFound[1] && pairsFound[2] && pairsFound[3]) {
            handRank = HandRank.FOUR_OF_A_KIND;

            tiebreakerCardRanks = new CardRank[2];
            tiebreakerCardRanks[0] = cards[4].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();

            return;
        }

        // Full house, bigger full of smaller
        if (pairsFound[0] && pairsFound[1] && pairsFound[3]) {
            handRank = HandRank.FULL_HOUSE;

            tiebreakerCardRanks = new CardRank[2];
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[4].getRank();

            return;
        }

        // Full house, smaller full of bigger
        if (pairsFound[0] && pairsFound[2] && pairsFound[3]) {
            handRank = HandRank.FULL_HOUSE;

            tiebreakerCardRanks = new CardRank[2];
            tiebreakerCardRanks[0] = cards[4].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();

            return;
        }

        // Three-of-a-kind, two smaller kickers
        if (pairsFound[0] && pairsFound[1]) {
            handRank = HandRank.THREE_OF_A_KIND;

            tiebreakerCardRanks = new CardRank[3];
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[3].getRank();
            tiebreakerCardRanks[2] = cards[4].getRank();

            return;
        }

        // Three-of-a-kind, one larger and one smaller kicker
        if (pairsFound[1] && pairsFound[2]) {
            handRank = HandRank.THREE_OF_A_KIND;

            tiebreakerCardRanks = new CardRank[3];
            tiebreakerCardRanks[0] = cards[2].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();
            tiebreakerCardRanks[2] = cards[4].getRank();

            return;
        }

        // Three-of-a-kind, two larger kickers
        if (pairsFound[2] && pairsFound[3]) {
            handRank = HandRank.THREE_OF_A_KIND;

            tiebreakerCardRanks = new CardRank[3];
            tiebreakerCardRanks[0] = cards[2].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();
            tiebreakerCardRanks[2] = cards[1].getRank();

            return;
        }

        // Two pair, kicker lower
        if (pairsFound[0] && pairsFound[2]) {
            handRank = HandRank.TWO_PAIR;

            tiebreakerCardRanks = new CardRank[3];
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[2].getRank();
            tiebreakerCardRanks[2] = cards[4].getRank();

            return;
        }

        // Two pair, kicker in the middle
        if (pairsFound[0] && pairsFound[3]) {
            handRank = HandRank.TWO_PAIR;

            tiebreakerCardRanks = new CardRank[3];
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[4].getRank();
            tiebreakerCardRanks[2] = cards[2].getRank();

            return;
        }

        // Two pair, kicker higher
        if (pairsFound[1] && pairsFound[3]) {
            handRank = HandRank.TWO_PAIR;

            tiebreakerCardRanks = new CardRank[3];
            tiebreakerCardRanks[0] = cards[2].getRank();
            tiebreakerCardRanks[1] = cards[4].getRank();
            tiebreakerCardRanks[2] = cards[0].getRank();

            return;
        }

        // One pair, higher than all kickers
        if (pairsFound[0]) {
            handRank = HandRank.ONE_PAIR;

            tiebreakerCardRanks = new CardRank[4];
            tiebreakerCardRanks[0] = cards[0].getRank();
            tiebreakerCardRanks[1] = cards[2].getRank();
            tiebreakerCardRanks[2] = cards[3].getRank();
            tiebreakerCardRanks[3] = cards[4].getRank();

            return;
        }

        // One pair, lower than one kicker
        if (pairsFound[1]) {
            handRank = HandRank.ONE_PAIR;

            tiebreakerCardRanks = new CardRank[4];
            tiebreakerCardRanks[0] = cards[1].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();
            tiebreakerCardRanks[2] = cards[3].getRank();
            tiebreakerCardRanks[3] = cards[4].getRank();

            return;
        }

        // One pair, higher than one kicker
        if (pairsFound[2]) {
            handRank = HandRank.ONE_PAIR;

            tiebreakerCardRanks = new CardRank[4];
            tiebreakerCardRanks[0] = cards[2].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();
            tiebreakerCardRanks[2] = cards[1].getRank();
            tiebreakerCardRanks[3] = cards[4].getRank();

            return;
        }

        // One pair, lower than all kickers
        if (pairsFound[3]) {
            handRank = HandRank.ONE_PAIR;

            tiebreakerCardRanks = new CardRank[4];
            tiebreakerCardRanks[0] = cards[3].getRank();
            tiebreakerCardRanks[1] = cards[0].getRank();
            tiebreakerCardRanks[2] = cards[1].getRank();
            tiebreakerCardRanks[3] = cards[2].getRank();

            return;
        }

        assert false; // Should never be reached

        return;
    }

    //@formatter:off
    /**
     * Here, a standard "higher" hand is considered "greater than" a standard "lower" hand in the natural ordering. The complete order:
     * 
     * +------------------------------------+---------------------------------------------------------------------------+
     * | (Highest)                          | (Tiebreak procedure)                                                      |
     * |                                    |                                                                           |
     * | Straight flush                     | Rank of highest card                                                      |
     * | Four of a kind                     | Rank of duplicate, then rank of remaining card                            |
     * | Full house                         | Rank of three-of-a-kind, then rank of pair                                |
     * | Flush                              | Rank of highest card                                                      |
     * | Straight                           | Rank of highest card                                                      |
     * | Three of a kind                    | Rank of duplicate, then rank of highest remaining card repeatedly         |
     * | Two pair                           | Rank of higher pair, then rank of lower pair, then rank of remaining card |
     * | One pair                           | Rank of pair, then rank of highest remaining card repeatedly              |
     * | High card (i.e. none of the above) | Rank of highest remaining card repeatedly                                 |
     * |                                    |                                                                           |
     * | (Lowest)                           | Ties are possible, and allowed, if the final tiebreaker is still a tie    |
     * +------------------------------------+---------------------------------------------------------------------------+
     * 
     * (The terms "winning" and "losing" are not used to avoid ambiguity with Razz, deuce-to-seven and other lowball games where low hands may be "best.")
     */
    //@formatter:on
    @Override
    public int compareTo(EvaluatedHand otherHand) {
        int handRankComparison = handRank.compareTo(otherHand.getHandRank());

        // If the hands are not of the same rank (e.g. full house vs. two pair), we already know the winner
        if (handRankComparison != 0) {
            return handRankComparison;
        }

        // If the hands have the same rank (e.g. flush vs. flush), go to tiebreaker
        CardRank[] otherTiebreakers = otherHand.getTiebreakers();

        assert (tiebreakerCardRanks.length == otherTiebreakers.length);

        int thisNextKicker;
        int otherNextKicker;
        for (int i = 0; i < tiebreakerCardRanks.length; i++) {
            thisNextKicker = tiebreakerCardRanks[i].getValue();
            otherNextKicker = otherTiebreakers[i].getValue();

            if (thisNextKicker == otherNextKicker) {
                // The tiebreakers are tied, go to next tiebreaker
                continue;
            } else {
                return thisNextKicker - otherNextKicker;
            }
        }

        // If ALL tiebreakers are exhausted, the hands are truly tied
        return 0;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public CardRank[] getTiebreakers() {
        return tiebreakerCardRanks;
    }

    @Override
    public String toString() {
        StringBuilder handDescription = new StringBuilder();
        char nextKicker;

        switch (handRank) {

            case STRAIGHT_FLUSH:
                handDescription.append(tiebreakerCardRanks[0].getSymbol());
                handDescription.append("-high straight flush");

                break;

            case FOUR_OF_A_KIND:
                handDescription.append("Quad ");
                handDescription.append(tiebreakerCardRanks[0].getSymbol());

                nextKicker = tiebreakerCardRanks[1].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, "s with an ", "s with a ");

                break;

            case FULL_HOUSE:
                handDescription.append(tiebreakerCardRanks[0].getSymbol());
                handDescription.append("s full of ");
                handDescription.append(tiebreakerCardRanks[1].getSymbol());
                handDescription.append("s");

                break;

            case FLUSH:
                handDescription.append(tiebreakerCardRanks[0].getSymbol());
                handDescription.append("-high flush");

                break;

            case STRAIGHT:
                handDescription.append("Straight to the ");
                handDescription.append(tiebreakerCardRanks[0].getSymbol());

                break;

            case THREE_OF_A_KIND:
                handDescription.append("Three ");
                handDescription.append(tiebreakerCardRanks[0].getSymbol());

                nextKicker = tiebreakerCardRanks[1].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, "s, with an ", "s, with a ");

                nextKicker = tiebreakerCardRanks[2].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, " and an ", " and a ");

                break;

            case TWO_PAIR:
                handDescription.append(tiebreakerCardRanks[0].getSymbol());
                handDescription.append("s and ");
                handDescription.append(tiebreakerCardRanks[1].getSymbol());

                nextKicker = tiebreakerCardRanks[2].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, "s with an ", "s with a ");

                break;

            case ONE_PAIR:
                handDescription.append("A pair of ");
                handDescription.append(tiebreakerCardRanks[0].getSymbol());

                nextKicker = tiebreakerCardRanks[1].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, "s with an ", "s with a ");

                nextKicker = tiebreakerCardRanks[2].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, ", an ", ", a ");

                nextKicker = tiebreakerCardRanks[3].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, " and an ", " and a ");

                break;

            case HIGH_CARD:
                handDescription.append(tiebreakerCardRanks[0].getSymbol());

                nextKicker = tiebreakerCardRanks[1].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, "-high, with an ", "-high, with a ");

                nextKicker = tiebreakerCardRanks[2].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, ", an ", ", a ");

                nextKicker = tiebreakerCardRanks[3].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, ", an ", ", a ");

                nextKicker = tiebreakerCardRanks[4].getSymbol();
                buildHandDescriptionHelper(nextKicker, handDescription, " and an ", " and a ");

                break;

            default:
                assert false; // Should never occur; all possible cases should be covered

                break;
        }

        return handDescription.toString();
    }

    private void buildHandDescriptionHelper(char nextKicker, StringBuilder handDescription, String vowelString, String consonantString) {
        if (nextKicker == '8' || nextKicker == 'A') {
            handDescription.append(vowelString);
        } else {
            handDescription.append(consonantString);
        }
        handDescription.append(nextKicker);
    }
}