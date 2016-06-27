package com.lolStone.client.model;

import com.lolStone.client.ParseSystemInfo;
import com.lolStone.client.model.ThreadWorkers.PacketThread;
import com.lolStone.client.model.ThreadWorkers.ThreadWorkAPI;
import com.lolStone.client.network.ToClientPacket;
import io.netty.channel.Channel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Wed on 10.02.16.
 */
public class Monkey {

    private static Monkey thisModel;
    private ClientInfo info=new ClientInfo();
    private PacketThread packetThread;
    private ThreadWorkAPI threadAPI;
    Channel chanel;

    public List<ToClientPacket> _packets= Collections.synchronizedList(new LinkedList<ToClientPacket>());
    public Map<String,Account> _accounts=new ConcurrentHashMap<>();

    public Monkey(Channel c)
    {
        thisModel=this;
        chanel=c;
        packetThread=new PacketThread();
        packetThread.start();
        threadAPI=new ThreadWorkAPI();
        threadAPI.start();
    }


    public ClientInfo getInfo() {
        return info;
    }

    public Channel getChanel()
    {
        return chanel;
    }

    public List<ToClientPacket> get_packets() {
        return _packets;
    }

    public Map<String, Account> get_accounts() {
        return _accounts;
    }

    public void addPacket(ToClientPacket packet)
    {
        _packets.add(packet);
    }

    public ToClientPacket getPacket()
    {
        ToClientPacket p=null;
        if (_packets.size() != 0) {
            p = _packets.get(0);
            _packets.remove(0);
        }
        return p;
    }

    public void close()
    {
        if(packetThread!=null)
            packetThread.Stop();
        if(threadAPI!=null)
            threadAPI.Stop();
        get_packets().clear();
        get_accounts().clear();
        thisModel=null;

    }

    public static Monkey Initialize()
    {
        return thisModel;
    }

    public void refresfInfo()
    {
        ParseSystemInfo.refresh(info);
    }
}
