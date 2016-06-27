package com.lolStone.client.network.ToClient;

import com.lolStone.client.network.ToClientPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 08.02.16.
 */
public class LoginPacket extends ToClientPacket {

    public boolean isAllOk;

    public void get(ByteBuf buffer) {
        isAllOk=buffer.readBoolean();
    }
}
