package indi.midreamsheep.schatapp.desktop.net.netty.prototcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * netty编码器
 * */

public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol msg, ByteBuf out) throws Exception {
        byte[] content = msg.getContent();
        out.writeInt(content.length);
        out.writeBytes(content);
    }
}