package indi.midreamsheep.schatapp.desktop.service.handler.type;

import indi.midreamsheep.schatapp.desktop.service.update.UpdateSignal;
import indi.midreamsheep.schatapp.desktop.service.handler.SChatAbstractHandler;
import io.netty.channel.ChannelHandlerContext;
import io.reactivex.ObservableEmitter;

public class EditHandler extends SChatAbstractHandler {

    public EditHandler(ObservableEmitter<UpdateSignal> emitter) {
        super(emitter);
    }

    @Override
    public void handle(ChannelHandlerContext channelHandlerContext, String s) {
        //处理业务逻辑
    }
}