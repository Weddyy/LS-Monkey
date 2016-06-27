package com.lolStone.client.network.ToServer;

import com.lolStone.client.network.ToServerPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 08.02.16.
 */
public class LoginPacket extends ToServerPacket {

    public int getId() {
        return 1;
    }

    public void send(ByteBuf buffer) {
        buffer.writeShort(6);
    }
}
