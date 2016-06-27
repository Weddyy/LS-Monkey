package com.lolStone.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

/**
 * Created by Wed on 08.02.16.
 */
public class SecureChatClientInitializer extends ChannelInitializer<SocketChannel> {


   // private final SslContext sslCtx;



    public SecureChatClientInitializer(/*SslContext sslCtx*/) {
       //  this.sslCtx = sslCtx;

    }

    @Override

    public void initChannel(SocketChannel ch) throws Exception {
         ChannelPipeline pipeline = ch.pipeline();

       //  pipeline.addLast(sslCtx.newHandler(ch.alloc(), Config.HOST, Config.PORT));

        pipeline.addLast(new Encoder());
        pipeline.addLast(new Decoder());

         pipeline.addLast(new SecureChatClientHandler());

    }
}
