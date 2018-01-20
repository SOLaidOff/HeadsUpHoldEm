package com.solaidoff.headsupholdem.poker.mechanics.hands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.solaidoff.headsupholdem.poker.PokerTestSuite;
import com.solaidoff.headsupholdem.poker.mechanics.HandRank;

public class EvaluatedHandTest {
    @Test
    public void testStraightFlushes() {
        EvaluatedHand hand1 = PokerTestSuite.strFlush_jhth9h8h7h;
        EvaluatedHand hand2 = PokerTestSuite.strFlush_5c4c3c2cac;
        EvaluatedHand hand3 = PokerTestSuite.strFlush_adkdqdjdtd;

        System.out.println("Straight flushes:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);

        assertTrue(hand1.getHandRank().equals(HandRank.STRAIGHT_FLUSH));
        assertTrue(hand2.getHandRank().equals(HandRank.STRAIGHT_FLUSH));
        assertTrue(hand3.getHandRank().equals(HandRank.STRAIGHT_FLUSH));
    }

    @Test
    public void testQuads() {
        EvaluatedHand hand1 = PokerTestSuite.quads_78h;
        EvaluatedHand hand2 = PokerTestSuite.quads_akd;
        EvaluatedHand hand3 = PokerTestSuite.quads_2td;

        System.out.println("Quads:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);

        assertTrue(hand1.getHandRank().equals(HandRank.FOUR_OF_A_KIND));
        assertTrue(hand2.getHandRank().equals(HandRank.FOUR_OF_A_KIND));
        assertTrue(hand3.getHandRank().equals(HandRank.FOUR_OF_A_KIND));
    }

    @Test
    public void testFullHouses() {
        EvaluatedHand hand1 = PokerTestSuite.fullHouse_7s7h7d9d9c;
        EvaluatedHand hand2 = PokerTestSuite.fullHouse_kskhkc9h9d;
        EvaluatedHand hand3 = PokerTestSuite.fullHouse_5h5d5cthtd;

        System.out.println("Boats:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);

        assertTrue(hand1.getHandRank().equals(HandRank.FULL_HOUSE));
        assertTrue(hand2.getHandRank().equals(HandRank.FULL_HOUSE));
        assertTrue(hand3.getHandRank().equals(HandRank.FULL_HOUSE));
    }

    @Test
    public void testFlushes() {
        EvaluatedHand hand1 = PokerTestSuite.flush_hahqhth9h7;
        EvaluatedHand hand2 = PokerTestSuite.flush_d9d6d4d3d2;
        EvaluatedHand hand3 = PokerTestSuite.flush_cacqc7c5c2;

        System.out.println("Flushes:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);

        assertTrue(hand1.getHandRank().equals(HandRank.FLUSH));
        assertTrue(hand2.getHandRank().equals(HandRank.FLUSH));
        assertTrue(hand3.getHandRank().equals(HandRank.FLUSH));
    }

    @Test
    public void testStraights() {
        EvaluatedHand hand1 = PokerTestSuite.straight_9h8d7d6s5s;
        EvaluatedHand hand2 = PokerTestSuite.straight_qdjctc9h8s;
        EvaluatedHand hand3 = PokerTestSuite.straight_6h5d4c3h2s;
        EvaluatedHand hand4 = PokerTestSuite.straight_ackdqcjdtc;
        EvaluatedHand hand5 = PokerTestSuite.straight_5d4h3h2sas;

        System.out.println("Straights:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);
        System.out.println(hand4);
        System.out.println(hand5);

        assertTrue(hand1.getHandRank().equals(HandRank.STRAIGHT));
        assertTrue(hand2.getHandRank().equals(HandRank.STRAIGHT));
        assertTrue(hand3.getHandRank().equals(HandRank.STRAIGHT));
        assertTrue(hand4.getHandRank().equals(HandRank.STRAIGHT));
        assertTrue(hand5.getHandRank().equals(HandRank.STRAIGHT));
    }

    @Test
    public void testThreeOfAKinds() {
        EvaluatedHand hand1 = PokerTestSuite.trips_5s5d5c9h8d;
        EvaluatedHand hand2 = PokerTestSuite.trips_tsthtcqdjc;
        EvaluatedHand hand3 = PokerTestSuite.trips_3s3h3d5d4c;
        EvaluatedHand hand4 = PokerTestSuite.trips_asadackdjd;
        EvaluatedHand hand5 = PokerTestSuite.trips_2s2c2has5d;

        System.out.println("Drilling:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);
        System.out.println(hand4);
        System.out.println(hand5);

        assertTrue(hand1.getHandRank().equals(HandRank.THREE_OF_A_KIND));
        assertTrue(hand2.getHandRank().equals(HandRank.THREE_OF_A_KIND));
        assertTrue(hand3.getHandRank().equals(HandRank.THREE_OF_A_KIND));
        assertTrue(hand4.getHandRank().equals(HandRank.THREE_OF_A_KIND));
        assertTrue(hand5.getHandRank().equals(HandRank.THREE_OF_A_KIND));
    }

    @Test
    public void testTwoPairs() {
        EvaluatedHand hand1 = PokerTestSuite.twoPair_8d8c5s5d9h;
        EvaluatedHand hand2 = PokerTestSuite.twoPair_qdqcthtcas;
        EvaluatedHand hand3 = PokerTestSuite.twoPair_4d4c3s3hjd;
        EvaluatedHand hand4 = PokerTestSuite.twoPair_asacjhjdkd;

        System.out.println("Two pairs:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);
        System.out.println(hand4);

        assertTrue(hand1.getHandRank().equals(HandRank.TWO_PAIR));
        assertTrue(hand2.getHandRank().equals(HandRank.TWO_PAIR));
        assertTrue(hand3.getHandRank().equals(HandRank.TWO_PAIR));
        assertTrue(hand4.getHandRank().equals(HandRank.TWO_PAIR));
    }

    @Test
    public void testOnePairs() {
        EvaluatedHand hand1 = PokerTestSuite.pair_5s5cad9h8d;
        EvaluatedHand hand2 = PokerTestSuite.pair_tsthqdjc2c;
        EvaluatedHand hand3 = PokerTestSuite.pair_3s3h5d4c2d;
        EvaluatedHand hand4 = PokerTestSuite.pair_asackdjd5d;

        System.out.println("Pairs:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);
        System.out.println(hand4);

        assertTrue(hand1.getHandRank().equals(HandRank.ONE_PAIR));
        assertTrue(hand2.getHandRank().equals(HandRank.ONE_PAIR));
        assertTrue(hand3.getHandRank().equals(HandRank.ONE_PAIR));
        assertTrue(hand4.getHandRank().equals(HandRank.ONE_PAIR));
    }

    @Test
    public void testHighCards() {
        EvaluatedHand hand1 = PokerTestSuite.highCard_ahqhtd9h7h;
        EvaluatedHand hand2 = PokerTestSuite.highCard_9c6d4s3h2d;
        EvaluatedHand hand3 = PokerTestSuite.highCard_acqs7c5c2c;

        System.out.println("High cards:");
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(hand3);

        assertTrue(hand1.getHandRank().equals(HandRank.HIGH_CARD));
        assertTrue(hand2.getHandRank().equals(HandRank.HIGH_CARD));
        assertTrue(hand3.getHandRank().equals(HandRank.HIGH_CARD));
    }
}
