package com.lolStone.client.model;

/**
 * Created by Wed on 04.02.16.
 */
public class Masteries{
    long masteryId;
    int rank;

    public Masteries(int rank, long masteryId) {
        this.rank = rank;
        this.masteryId = masteryId;
    }

    public int getRank() {
        return rank;
    }

    public long getMasteryId() {
        return masteryId;
    }
}