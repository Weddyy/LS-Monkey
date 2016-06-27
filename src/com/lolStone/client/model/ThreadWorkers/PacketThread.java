package com.lolStone.client.model.ThreadWorkers;

import com.lolStone.client.model.Loggs;
import com.lolStone.client.model.Monkey;
import com.lolStone.client.network.ToClient.getInfo;
import com.lolStone.client.network.ToClientPacket;
import com.lolStone.client.network.ToServer.Info;

/**
 * Created by Wed on 10.02.16.
 */
public class PacketThread extends Thread {

    Loggs _log=new Loggs();
    private boolean isStart=true;

    public void Stop()
    {
        isStart=false;
    }

    @Override
    public void run()
    {
        ToClientPacket packet;
        while (isStart)
        {
            packet = Monkey.Initialize().getPacket();
            if(packet!=null)
            {
                if(packet instanceof getInfo)
                {
                    Monkey.Initialize().refresfInfo();
                    Monkey.Initialize().getChanel().writeAndFlush(new Info(Monkey.Initialize().getInfo()));
                }
            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){_log.info(e);}
        }
    }
}
