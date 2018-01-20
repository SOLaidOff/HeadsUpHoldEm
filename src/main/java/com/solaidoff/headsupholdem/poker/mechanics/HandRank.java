package com.solaidoff.headsupholdem.poker.mechanics;

public enum HandRank {
    //@formatter:off
    HIGH_CARD           ("high card"),
    ONE_PAIR            ("pair"),
    TWO_PAIR            ("two pair"),
    THREE_OF_A_KIND     ("three of a kind"),
    STRAIGHT            ("straight"),
    FLUSH               ("flush"),
    FULL_HOUSE          ("full house"),
    FOUR_OF_A_KIND      ("quads"),
    STRAIGHT_FLUSH      ("straight flush");
    //@formatter:on

    private String name;

    private HandRank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}