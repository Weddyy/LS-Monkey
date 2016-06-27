package com.lolStone.client;

import com.lolStone.client.model.Loggs;
import com.lolStone.client.model.Monkey;
import com.lolStone.client.network.ToClient.LoginPacket;
import com.lolStone.client.network.ToClientPacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wed on 08.02.16.
 */
public class SecureChatClientHandler extends SimpleChannelInboundHandler<ToClientPacket> {
    Loggs _log=new Loggs();
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        ctx.writeAndFlush(new com.lolStone.client.network.ToServer.LoginPacket());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ToClientPacket msg) {
        if(Monkey.Initialize()==null) {
            if (msg instanceof LoginPacket) {
                if (((LoginPacket) msg).isAllOk) {
                    new Monkey(ctx.channel());
                    _log.info("Connect to server.");
                }
            }
        }else
        {
            Monkey.Initialize().addPacket(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
         cause.printStackTrace();
         ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        _log.info("Server disconnect");
        if(Monkey.Initialize()!=null) Monkey.Initialize().close();
        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.shutdown();
        super.channelInactive(ctx);
    }
}