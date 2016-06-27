package com.lolStone.client.network.ToServer;

import com.lolStone.client.model.ClientInfo;
import com.lolStone.client.network.ToServerPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 09.02.16.
 */
public class Info extends ToServerPacket {

    private ClientInfo _info;
    public int getId() {
        return 2;
    }
    public Info(ClientInfo info)
    {
        _info=info;
    }

    public void send(ByteBuf buffer) {
        buffer.writeDouble(_info.getCPU_IdleTime());
        buffer.writeDouble(_info.getMem_used());
        buffer.writeDouble(_info.getMem_free());
        buffer.writeDouble(_info.getSwap_used());
        buffer.writeDouble(_info.getSwap_free());

        buffer.writeInt(_info.getCountUsers());
        buffer.writeLong(_info.getTimeForOneRound());
        buffer.writeLong(_info.getTimeLastRequestonAPI());
        buffer.writeLong(_info.getTimeLastRequestonInfo());
    }
}
