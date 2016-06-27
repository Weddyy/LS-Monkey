package com.lolStone.client.network;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by Wed on 09.02.16.
 */
public abstract class ToClientPacket {

    public static ToClientPacket read(ByteBuf buffer) throws IOException {
        int id = buffer.readUnsignedShort(); // Получаем ID пришедшего пакета, чтобы определить, каким классом его читать
        ToClientPacket packet = ToClientWorker.parse(id); // Получаем инстанс пакета с этим ID
        if(packet == null)
            throw new IOException("Bad packet ID: " + id); // Если произошла ошибка и такого пакета не может быть, генерируем исключение
        packet.get(buffer); // Читаем в пакет данные из буфера
        return packet;
    }

    public abstract void get(ByteBuf buffer);
}
