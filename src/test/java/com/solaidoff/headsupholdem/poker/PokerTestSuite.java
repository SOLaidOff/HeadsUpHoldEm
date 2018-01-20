package com.solaidoff.headsupholdem.poker;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import com.solaidoff.headsupholdem.poker.mechanics.Card;
import com.solaidoff.headsupholdem.poker.mechanics.CardRank;
import com.solaidoff.headsupholdem.poker.mechanics.CardSuit;
import com.solaidoff.headsupholdem.poker.mechanics.hands.EvaluatedHand;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.solaidoff.headsupholdem.poker.mechanics.hands")

/**
 * Common, basic setup tasks. Creates card objects and sample hands that may be reused repeatedly among multiple tests.
 */
@SuppressWarnings("unused")
public class PokerTestSuite {
    private static Card s2;
    private static Card s3;
    private static Card s4;
    private static Card s5;
    private static Card s6;
    private static Card s7;
    private static Card s8;
    private static Card s9;
    private static Card st;
    private static Card sj;
    private static Card sq;
    private static Card sk;
    private static Card sa;

    private static Card h2;
    private static Card h3;
    private static Card h4;
    private static Card h5;
    private static Card h6;
    private static Card h7;
    private static Card h8;
    private static Card h9;
    private static Card ht;
    private static Card hj;
    private static Card hq;
    private static Card hk;
    private static Card ha;

    private static Card d2;
    private static Card d3;
    private static Card d4;
    private static Card d5;
    private static Card d6;
    private static Card d7;
    private static Card d8;
    private static Card d9;
    private static Card dt;
    private static Card dj;
    private static Card dq;
    private static Card dk;
    private static Card da;

    private static Card c2;
    private static Card c3;
    private static Card c4;
    private static Card c5;
    private static Card c6;
    private static Card c7;
    private static Card c8;
    private static Card c9;
    private static Card ct;
    private static Card cj;
    private static Card cq;
    private static Card ck;
    private static Card ca;

    private static Collection<Card> cards;

    public static EvaluatedHand strFlush_jhth9h8h7h;
    public static EvaluatedHand strFlush_5c4c3c2cac;
    public static EvaluatedHand strFlush_adkdqdjdtd;
    public static EvaluatedHand quads_78h;
    public static EvaluatedHand quads_akd;
    public static EvaluatedHand quads_2td;
    public static EvaluatedHand fullHouse_7s7h7d9d9c;
    public static EvaluatedHand fullHouse_kskhkc9h9d;
    public static EvaluatedHand fullHouse_5h5d5cthtd;
    public static EvaluatedHand flush_hahqhth9h7;
    public static EvaluatedHand flush_d9d6d4d3d2;
    public static EvaluatedHand flush_cacqc7c5c2;
    public static EvaluatedHand straight_9h8d7d6s5s;
    public static EvaluatedHand straight_qdjctc9h8s;
    public static EvaluatedHand straight_6h5d4c3h2s;
    public static EvaluatedHand straight_ackdqcjdtc;
    public static EvaluatedHand straight_5d4h3h2sas;
    public static EvaluatedHand trips_5s5d5c9h8d;
    public static EvaluatedHand trips_tsthtcqdjc;
    public static EvaluatedHand trips_3s3h3d5d4c;
    public static EvaluatedHand trips_asadackdjd;
    public static EvaluatedHand trips_2s2c2has5d;
    public static EvaluatedHand twoPair_8d8c5s5d9h;
    public static EvaluatedHand twoPair_qdqcthtcas;
    public static EvaluatedHand twoPair_4d4c3s3hjd;
    public static EvaluatedHand twoPair_asacjhjdkd;
    public static EvaluatedHand pair_5s5cad9h8d;
    public static EvaluatedHand pair_tsthqdjc2c;
    public static EvaluatedHand pair_3s3h5d4c2d;
    public static EvaluatedHand pair_asackdjd5d;
    public static EvaluatedHand highCard_ahqhtd9h7h;
    public static EvaluatedHand highCard_9c6d4s3h2d;
    public static EvaluatedHand highCard_acqs7c5c2c;

    @BeforeAll
    public static void setUp() {
        System.out.println("If working as desired, this line will only print once per run OF ENTIRE TEST SUITE, not merely once per test class."); // DEBUG
    }

    @BeforeAll
    public static void createDeck() {
        s2 = new Card(CardSuit.SPADES, CardRank.TWO);
        s3 = new Card(CardSuit.SPADES, CardRank.THREE);
        s4 = new Card(CardSuit.SPADES, CardRank.FOUR);
        s5 = new Card(CardSuit.SPADES, CardRank.FIVE);
        s6 = new Card(CardSuit.SPADES, CardRank.SIX);
        s7 = new Card(CardSuit.SPADES, CardRank.SEVEN);
        s8 = new Card(CardSuit.SPADES, CardRank.EIGHT);
        s9 = new Card(CardSuit.SPADES, CardRank.NINE);
        st = new Card(CardSuit.SPADES, CardRank.TEN);
        sj = new Card(CardSuit.SPADES, CardRank.JACK);
        sq = new Card(CardSuit.SPADES, CardRank.QUEEN);
        sk = new Card(CardSuit.SPADES, CardRank.KING);
        sa = new Card(CardSuit.SPADES, CardRank.ACE);

        h2 = new Card(CardSuit.HEARTS, CardRank.TWO);
        h3 = new Card(CardSuit.HEARTS, CardRank.THREE);
        h4 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        h5 = new Card(CardSuit.HEARTS, CardRank.FIVE);
        h6 = new Card(CardSuit.HEARTS, CardRank.SIX);
        h7 = new Card(CardSuit.HEARTS, CardRank.SEVEN);
        h8 = new Card(CardSuit.HEARTS, CardRank.EIGHT);
        h9 = new Card(CardSuit.HEARTS, CardRank.NINE);
        ht = new Card(CardSuit.HEARTS, CardRank.TEN);
        hj = new Card(CardSuit.HEARTS, CardRank.JACK);
        hq = new Card(CardSuit.HEARTS, CardRank.QUEEN);
        hk = new Card(CardSuit.HEARTS, CardRank.KING);
        ha = new Card(CardSuit.HEARTS, CardRank.ACE);

        d2 = new Card(CardSuit.DIAMONDS, CardRank.TWO);
        d3 = new Card(CardSuit.DIAMONDS, CardRank.THREE);
        d4 = new Card(CardSuit.DIAMONDS, CardRank.FOUR);
        d5 = new Card(CardSuit.DIAMONDS, CardRank.FIVE);
        d6 = new Card(CardSuit.DIAMONDS, CardRank.SIX);
        d7 = new Card(CardSuit.DIAMONDS, CardRank.SEVEN);
        d8 = new Card(CardSuit.DIAMONDS, CardRank.EIGHT);
        d9 = new Card(CardSuit.DIAMONDS, CardRank.NINE);
        dt = new Card(CardSuit.DIAMONDS, CardRank.TEN);
        dj = new Card(CardSuit.DIAMONDS, CardRank.JACK);
        dq = new Card(CardSuit.DIAMONDS, CardRank.QUEEN);
        dk = new Card(CardSuit.DIAMONDS, CardRank.KING);
        da = new Card(CardSuit.DIAMONDS, CardRank.ACE);

        c2 = new Card(CardSuit.CLUBS, CardRank.TWO);
        c3 = new Card(CardSuit.CLUBS, CardRank.THREE);
        c4 = new Card(CardSuit.CLUBS, CardRank.FOUR);
        c5 = new Card(CardSuit.CLUBS, CardRank.FIVE);
        c6 = new Card(CardSuit.CLUBS, CardRank.SIX);
        c7 = new Card(CardSuit.CLUBS, CardRank.SEVEN);
        c8 = new Card(CardSuit.CLUBS, CardRank.EIGHT);
        c9 = new Card(CardSuit.CLUBS, CardRank.NINE);
        ct = new Card(CardSuit.CLUBS, CardRank.TEN);
        cj = new Card(CardSuit.CLUBS, CardRank.JACK);
        cq = new Card(CardSuit.CLUBS, CardRank.QUEEN);
        ck = new Card(CardSuit.CLUBS, CardRank.KING);
        ca = new Card(CardSuit.CLUBS, CardRank.ACE);
    }

    @BeforeAll
    public static void createEvaluatedHands() {
        cards = new ArrayList<Card>();

        cards.clear();
        cards.add(h7);
        cards.add(h8);
        cards.add(h9);
        cards.add(ht);
        cards.add(hj);
        strFlush_jhth9h8h7h = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c4);
        cards.add(c2);
        cards.add(ca);
        cards.add(c5);
        cards.add(c3);
        strFlush_5c4c3c2cac = new EvaluatedHand(cards);

        // Technically this one is a royal flush but the system isn't counting that as a separate rank, at least for now
        cards.clear();
        cards.add(da);
        cards.add(dk);
        cards.add(dq);
        cards.add(dj);
        cards.add(dt);
        strFlush_adkdqdjdtd = new EvaluatedHand(cards);

        cards.clear();
        cards.add(h7);
        cards.add(h8);
        cards.add(s7);
        cards.add(d7);
        cards.add(c7);
        quads_78h = new EvaluatedHand(cards);

        cards.clear();
        cards.add(dk);
        cards.add(da);
        cards.add(ca);
        cards.add(ha);
        cards.add(sa);
        quads_akd = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c2);
        cards.add(d2);
        cards.add(s2);
        cards.add(h2);
        cards.add(dt);
        quads_2td = new EvaluatedHand(cards);

        cards.clear();
        cards.add(h7);
        cards.add(s7);
        cards.add(d7);
        cards.add(c9);
        cards.add(d9);
        fullHouse_7s7h7d9d9c = new EvaluatedHand(cards);

        cards.clear();
        cards.add(d9);
        cards.add(h9);
        cards.add(ck);
        cards.add(hk);
        cards.add(sk);
        fullHouse_kskhkc9h9d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c5);
        cards.add(dt);
        cards.add(s5);
        cards.add(ht);
        cards.add(d5);
        fullHouse_5h5d5cthtd = new EvaluatedHand(cards);

        cards.clear();
        cards.add(h7);
        cards.add(h9);
        cards.add(ht);
        cards.add(hq);
        cards.add(ha);
        flush_hahqhth9h7 = new EvaluatedHand(cards);

        cards.clear();
        cards.add(d9);
        cards.add(d6);
        cards.add(d4);
        cards.add(d3);
        cards.add(d2);
        flush_d9d6d4d3d2 = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c5);
        cards.add(ca);
        cards.add(c7);
        cards.add(c2);
        cards.add(cq);
        flush_cacqc7c5c2 = new EvaluatedHand(cards);

        cards.clear();
        cards.add(s5);
        cards.add(s6);
        cards.add(d7);
        cards.add(d8);
        cards.add(h9);
        straight_9h8d7d6s5s = new EvaluatedHand(cards);

        cards.clear();
        cards.add(dq);
        cards.add(cj);
        cards.add(ct);
        cards.add(h9);
        cards.add(s8);
        straight_qdjctc9h8s = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c4);
        cards.add(s2);
        cards.add(h6);
        cards.add(h3);
        cards.add(d5);
        straight_6h5d4c3h2s = new EvaluatedHand(cards);

        cards.clear();
        cards.add(ca);
        cards.add(dk);
        cards.add(ct);
        cards.add(dj);
        cards.add(cq);
        straight_ackdqcjdtc = new EvaluatedHand(cards);

        cards.clear();
        cards.add(h3);
        cards.add(d5);
        cards.add(s2);
        cards.add(h4);
        cards.add(sa);
        straight_5d4h3h2sas = new EvaluatedHand(cards);

        cards.clear();
        cards.add(s5);
        cards.add(c5);
        cards.add(d5);
        cards.add(d8);
        cards.add(h9);
        trips_5s5d5c9h8d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(dq);
        cards.add(cj);
        cards.add(ct);
        cards.add(ht);
        cards.add(st);
        trips_tsthtcqdjc = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c4);
        cards.add(s3);
        cards.add(d3);
        cards.add(h3);
        cards.add(d5);
        trips_3s3h3d5d4c = new EvaluatedHand(cards);

        cards.clear();
        cards.add(ca);
        cards.add(dk);
        cards.add(dj);
        cards.add(sa);
        cards.add(da);
        trips_asadackdjd = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c2);
        cards.add(d5);
        cards.add(s2);
        cards.add(h2);
        cards.add(sa);
        trips_2s2c2has5d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(s5);
        cards.add(c8);
        cards.add(d5);
        cards.add(d8);
        cards.add(h9);
        twoPair_8d8c5s5d9h = new EvaluatedHand(cards);

        cards.clear();
        cards.add(dq);
        cards.add(cq);
        cards.add(ct);
        cards.add(ht);
        cards.add(sa);
        twoPair_qdqcthtcas = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c4);
        cards.add(s3);
        cards.add(dj);
        cards.add(h3);
        cards.add(d4);
        twoPair_4d4c3s3hjd = new EvaluatedHand(cards);

        cards.clear();
        cards.add(ca);
        cards.add(dk);
        cards.add(hj);
        cards.add(dj);
        cards.add(sa);
        twoPair_asacjhjdkd = new EvaluatedHand(cards);

        cards.clear();
        cards.add(s5);
        cards.add(c5);
        cards.add(da);
        cards.add(d8);
        cards.add(h9);
        pair_5s5cad9h8d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(dq);
        cards.add(cj);
        cards.add(c2);
        cards.add(ht);
        cards.add(st);
        pair_tsthqdjc2c = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c4);
        cards.add(s3);
        cards.add(d2);
        cards.add(h3);
        cards.add(d5);
        pair_3s3h5d4c2d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(ca);
        cards.add(dk);
        cards.add(d5);
        cards.add(dj);
        cards.add(sa);
        pair_asackdjd5d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(h7);
        cards.add(h9);
        cards.add(dt);
        cards.add(hq);
        cards.add(ha);
        highCard_ahqhtd9h7h = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c9);
        cards.add(s4);
        cards.add(d6);
        cards.add(h3);
        cards.add(d2);
        highCard_9c6d4s3h2d = new EvaluatedHand(cards);

        cards.clear();
        cards.add(c5);
        cards.add(ca);
        cards.add(c7);
        cards.add(c2);
        cards.add(sq);
        highCard_acqs7c5c2c = new EvaluatedHand(cards);
    }
}
