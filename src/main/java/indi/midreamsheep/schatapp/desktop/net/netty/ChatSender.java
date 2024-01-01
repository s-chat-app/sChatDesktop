package indi.midreamsheep.schatapp.desktop.net.netty;

import indi.midreamsheep.schatapp.desktop.net.netty.prototcp.MessageProtocol;
import io.netty.channel.Channel;


public record ChatSender(Channel channel) {

    public void send(String message) {
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(message.getBytes().length);
        messageProtocol.setContent(message.getBytes());
        channel.writeAndFlush(messageProtocol);
    }


}
