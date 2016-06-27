package com.lolStone.client.network;

import com.lolStone.client.network.ToClient.*;

/**
 * Created by Wed on 09.02.16.
 */
public class ToClientWorker {

    public static ToClientPacket parse(int id)
    {
        switch (id)
        {
            case 1:
                return new LoginPacket();
            case 2:
                return new Logout();
            case 3:
                return new getInfo();
            case 4:
                return new addWork();
            case 5:
                return new removeWork();
            case 6:
                return new stopWork();
            default: return null;
        }
    }
}
