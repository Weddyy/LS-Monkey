package com.lolStone.client.network.ToServer;

import com.lolStone.client.model.GameInfo;
import com.lolStone.client.network.ToServerPacket;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by Wed on 09.02.16.
 */
public class GameStart extends ToServerPacket {
    GameInfo _info;
    public GameStart(GameInfo info)
    {
        _info=info;
    }

    public int getId() {
        return 3;
    }

    public void send(ByteBuf buffer) {

        buffer.writeLong(_info.getGameLength());
        buffer.writeLong(_info.getGameStartTime());
        buffer.writeLong(_info.getGameId());
        buffer.writeLong(_info.getGameQueueConfigId());
        buffer.writeLong(_info.getMapId());

        buffer.writeInt(_info.getGameMode().getBytes().length);
        buffer.writeBytes(_info.getGameMode().getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(_info.getGameType().getBytes().length);
        buffer.writeBytes(_info.getGameType().getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(_info.getEncryptionKey().getBytes().length);
        buffer.writeBytes(_info.getEncryptionKey().getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(_info.getPlatformId().getBytes().length);
        buffer.writeBytes(_info.getPlatformId().getBytes(Charset.forName("UTF-8")));

        buffer.writeInt(_info.get_banChampion().size());

        for(int i=0;i<_info.get_banChampion().size();i++)
        {
            buffer.writeLong(_info.get_banChampion().get(i).getChampionId());
            buffer.writeLong(_info.get_banChampion().get(i).getTeamId());
            buffer.writeInt(_info.get_banChampion().get(i).getPickTurn());
        }

        buffer.writeInt(_info.getPlayers().size());

        for(int i=0;i<_info.getPlayers().size();i++)
        {
            buffer.writeBoolean(_info.getPlayers().get(i).isBot());
            buffer.writeLong(_info.getPlayers().get(i).getSpell1Id());
            buffer.writeLong(_info.getPlayers().get(i).getSpell2Id());
            buffer.writeLong(_info.getPlayers().get(i).getProfileIconId());
            buffer.writeLong(_info.getPlayers().get(i).getChampionId());
            buffer.writeLong(_info.getPlayers().get(i).getTeamId());
            buffer.writeLong(_info.getPlayers().get(i).getSummonerId());

            buffer.writeInt(_info.getPlayers().get(i).getSummonerName().getBytes().length);
            buffer.writeBytes(_info.getPlayers().get(i).getSummonerName().getBytes(Charset.forName("UTF-8")));

            buffer.writeInt(_info.getPlayers().get(i).getMasteries().size());

            for(int t=0;t<_info.getPlayers().get(i).getMasteries().size();t++)
            {
                buffer.writeLong(_info.getPlayers().get(i).getMasteries().get(t).getMasteryId());
                buffer.writeInt(_info.getPlayers().get(i).getMasteries().get(t).getRank());
            }

            buffer.writeInt(_info.getPlayers().get(i).getRune().size());

            for(int t=0;t<_info.getPlayers().get(i).getRune().size();t++)
            {
                buffer.writeLong(_info.getPlayers().get(i).getRune().get(t).getRuneId());
                buffer.writeInt(_info.getPlayers().get(i).getRune().get(t).getCount());
            }
        }

    }
}
