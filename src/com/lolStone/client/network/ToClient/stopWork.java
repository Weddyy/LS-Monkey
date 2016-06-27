package com.lolStone.client.network.ToClient;

import com.lolStone.client.model.Monkey;
import com.lolStone.client.network.ToClientPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 10.02.16.
 */
public class stopWork extends ToClientPacket {
    public void get(ByteBuf buffer) {
        if(Monkey.Initialize()!=null) {
            Monkey.Initialize().get_accounts().clear();
            Monkey.Initialize().getInfo().clearUsers();
        }
    }
}