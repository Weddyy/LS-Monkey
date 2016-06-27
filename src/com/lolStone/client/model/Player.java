package com.lolStone.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wed on 04.02.16.
 */
public class Player {
    boolean isBot;
    long spell1Id,spell2Id,profileIconId,championId,teamId,summonerId;
    String summonerName;
    List<Masteries> masteries=new ArrayList<>();
    List<Rune> rune=new ArrayList<>();

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(long spell2Id) {
        this.spell2Id = spell2Id;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public List<Masteries> getMasteries() {
        return masteries;
    }

    public List<Rune> getRune() {
        return rune;
    }
}
