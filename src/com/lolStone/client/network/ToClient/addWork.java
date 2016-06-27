package com.lolStone.client.network.ToClient;

import com.lolStone.client.model.Account;
import com.lolStone.client.model.Monkey;
import com.lolStone.client.network.ToClientPacket;
import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 10.02.16.
 */
public class addWork  extends ToClientPacket {

    public void get(ByteBuf buffer) {
        if(Monkey.Initialize()!=null) {
            int count = buffer.readInt();
            for (int i = 0;i <count;i++)
            {
                Account a=new Account(buffer.readLong(),buffer.readShort());
                Monkey.Initialize().get_accounts().put(a.getKey(),a);
                Monkey.Initialize().getInfo().addUser();
            }
        }
    }
}
