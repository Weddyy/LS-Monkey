package com.lolStone.client.model.ThreadWorkers;

import com.lolStone.client.model.API.GameAPI;
import com.lolStone.client.model.Account;
import com.lolStone.client.model.GameInfo;
import com.lolStone.client.model.Loggs;
import com.lolStone.client.model.Monkey;
import com.lolStone.client.network.ToServer.GameStart;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wed on 10.02.16.
 */
public class ThreadWorkAPI extends Thread {

    Loggs _log=new Loggs();
    private boolean isStart=true;
    private GameAPI api=new GameAPI();

    public void Stop()
    {
        isStart=false;
    }

    @Override
    public void run()
    {
        Monkey monkey=Monkey.Initialize();
        while (isStart)
        {
            long currentMilisecond= System.currentTimeMillis();
                if(monkey.get_accounts().size()==0)
                {
                    try{
                        TimeUnit.MINUTES.sleep(1);
                    }catch (InterruptedException e){_log.info(e);}
                    continue;
                }
            for(Account a:monkey.get_accounts().values())
            {
                monkey.getInfo().setTimeLastRequestonAPI(System.currentTimeMillis());

                GameInfo g=api.getGame(a.get_id(),a.get_serverId());
                if(g!=null)
                {
                    monkey.getChanel().writeAndFlush(new GameStart(g));
                }
            }
            monkey.getInfo().setTimeForOneRound(System.currentTimeMillis() - currentMilisecond);

            try{
                if(monkey.getInfo().getTimeForOneRound()<120000)
                Thread.sleep(120000 - monkey.getInfo().getTimeForOneRound());
            }catch (Exception e){_log.info(e);}
        }
    }
}
