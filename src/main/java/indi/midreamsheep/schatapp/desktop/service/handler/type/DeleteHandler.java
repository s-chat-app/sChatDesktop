package indi.midreamsheep.schatapp.desktop.service.handler.type;

import indi.midreamsheep.schatapp.desktop.service.command.UpdateSignal;
import indi.midreamsheep.schatapp.desktop.service.handler.SChatAbstractHandler;
import io.netty.channel.ChannelHandlerContext;
import io.reactivex.ObservableEmitter;

public class DeleteHandler extends SChatAbstractHandler {

    public DeleteHandler(ObservableEmitter<UpdateSignal> emitter) {
        super(emitter);
    }


    @Override
    public void handle(ChannelHandlerContext channelHandlerContext, String s) {

    }
}
