package com.lolStone.client.model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Wed on 04.02.16.
 */
public class JSONParser {

    public static long getCharID(String msg)
    {
        JSONObject obj = new JSONObject(msg);
        String name = (String) obj.keys().next();
        return obj.getJSONObject(name).getLong("id");
    }

    public static GameInfo getGameIdAndURL(String msg) {
        GameInfo game = new GameInfo();
        JSONObject obj = new JSONObject(msg);
        game.setGameId(obj.getLong("gameId"));
        game.setEncryptionKey(obj.getJSONObject("observers").getString("encryptionKey"));
        game.setGameLength(obj.getLong("gameLength"));
        game.setGameMode(obj.getString("gameMode"));
        game.setMapId(obj.getLong("mapId"));
        JSONArray listBans=obj.getJSONArray("bannedChampions");
        if(listBans.length()!=0)
        {
            for(int i=0;i<listBans.length();i++)
            {
                BannedChampion ban=new BannedChampion();
                ban.setChampionId(listBans.getJSONObject(i).getLong("championId"));
                ban.setPickTurn(listBans.getJSONObject(i).getInt("pickTurn"));
                ban.setTeamId(listBans.getJSONObject(i).getLong("teamId"));
                game.get_banChampion().add(ban);

            }

        }
        game.setGameType(obj.getString("gameType"));
        try {
            game.setGameQueueConfigId(obj.getLong("gameQueueConfigId"));
        }catch (Exception e)
        {
            new Loggs().info(e);
            game.setGameQueueConfigId(0);
        }
        game.setGameStartTime(obj.getLong("gameStartTime"));
        game.setPlatformId(obj.getString("platformId"));

        JSONArray listParticipants=obj.getJSONArray("participants");
        if(listParticipants.length()!=0)
        {
            for(int i=0;i<listParticipants.length();i++)
            {
                Player player=new Player();
                JSONArray listMasteris=listParticipants.getJSONObject(i).getJSONArray("masteries");
                if(listMasteris.length()!=0) {
                    for (int m = 0; m < listMasteris.length(); m++) {
                        player.getMasteries().add(new Masteries(listMasteris.getJSONObject(m).getInt("rank"),listMasteris.getJSONObject(m).getLong("masteryId")));
                    }
                }

                JSONArray listRune=listParticipants.getJSONObject(i).getJSONArray("runes");
                if(listRune.length()!=0) {
                    for (int m = 0; m < listRune.length(); m++) {
                        player.getRune().add(new Rune(listRune.getJSONObject(m).getInt("count"),listRune.getJSONObject(m).getLong("runeId")));
                    }
                }
                player.setSpell1Id(listParticipants.getJSONObject(i).getLong("spell1Id"));
                player.setSpell2Id(listParticipants.getJSONObject(i).getLong("spell2Id"));
                player.setProfileIconId(listParticipants.getJSONObject(i).getLong("profileIconId"));
                player.setSummonerName(listParticipants.getJSONObject(i).getString("summonerName"));
                player.setChampionId(listParticipants.getJSONObject(i).getLong("championId"));
                player.setTeamId(listParticipants.getJSONObject(i).getLong("teamId"));
                player.setSummonerId(listParticipants.getJSONObject(i).getLong("summonerId"));
                game.getPlayers().add(player);
            }

        }
        return game;
    }

}
