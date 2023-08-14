package indi.midreamsheep.schatapp.desktop.service.handler.type;

import indi.midreamsheep.schatapp.desktop.service.command.UpdateSignal;
import indi.midreamsheep.schatapp.desktop.service.handler.SChatAbstractHandler;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import io.netty.channel.ChannelHandlerContext;
import io.reactivex.ObservableEmitter;

public class SendHandler extends SChatAbstractHandler {

    public SendHandler(ObservableEmitter<UpdateSignal> emitter) {
        super(emitter);
    }

    @Override
    public void handle(ChannelHandlerContext channelHandlerContext, String s) {
        //处理业务逻辑
    }
}
