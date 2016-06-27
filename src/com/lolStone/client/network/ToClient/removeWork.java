package com.lolStone.client.network.ToClient;

import com.lolStone.client.model.Account;
import com.lolStone.client.model.Monkey;
import com.lolStone.client.network.ToClientPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 10.02.16.
 */
public class removeWork  extends ToClientPacket {

    public void get(ByteBuf buffer) {
        if(Monkey.Initialize()!=null) {
            int count = buffer.readInt();
            for (int i = 0;i <count;i++)
            {
                Monkey.Initialize().get_accounts().remove(Account.getKey(buffer.readLong(),buffer.readShort()));
                Monkey.Initialize().getInfo().removeUser();
            }
        }
    }
}
