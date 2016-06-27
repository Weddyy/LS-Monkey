package com.lolStone.client.network;

import io.netty.buffer.ByteBuf;

/**
 * Created by Wed on 09.02.16.
 */
public abstract class ToServerPacket
{
    public static void write(ToServerPacket packet, ByteBuf buffer) {
        buffer.writeChar(packet.getId()); // Отправляем ID пакета
        packet.send(buffer); // Отправляем данные пакета
    }

    public abstract void send(ByteBuf buffer);
    public abstract int getId();
}
