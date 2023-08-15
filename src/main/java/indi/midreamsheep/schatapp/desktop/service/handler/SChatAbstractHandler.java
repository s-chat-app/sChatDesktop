package indi.midreamsheep.schatapp.desktop.service.handler;

import indi.midreamsheep.schatapp.desktop.service.update.UpdateSignal;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import io.netty.channel.ChannelHandlerContext;
import io.reactivex.ObservableEmitter;

public abstract class SChatAbstractHandler implements ChatHandler {

    protected ObservableEmitter<UpdateSignal> emitter;

    public SChatAbstractHandler(ObservableEmitter<UpdateSignal> emitter){
        this.emitter = emitter;
    }

    @Override
    public void handler(ChannelHandlerContext channelHandlerContext, String s) {
        handle(channelHandlerContext, s);
        emitter.onNext(UpdateSignal.getInstance());
    }

    public abstract void handle(ChannelHandlerContext channelHandlerContext, String s);

}
