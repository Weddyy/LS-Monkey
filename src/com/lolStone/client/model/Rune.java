package com.lolStone.client.model;

/**
 * Created by Wed on 04.02.16.
 */
public class Rune{
    int count;
    long runeId;

    public Rune(int count, long runeId) {
        this.count = count;
        this.runeId = runeId;
    }

    public int getCount() {
        return count;
    }

    public long getRuneId() {
        return runeId;
    }
}