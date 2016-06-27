package com.lolStone.client.model;

import com.lolStone.client.enums.ServerId;

/**
 * Created by Wed on 10.02.16.
 */
public class Account {
    private long _id;
    private ServerId _serverId;

    public Account(long id, int serverid)
    {
        _id=id;
        _serverId=ServerId.values()[serverid];
    }

    public long get_id() {
        return _id;
    }

    public ServerId get_serverId() {
        return _serverId;
    }

    public String getKey()
    {
        return String.valueOf(_id)+" "+ String.valueOf(_serverId.getValue());
    }

    public static String getKey(long id, int serverId)
    {
        return String.valueOf(id)+" "+ String.valueOf(serverId);
    }
}
