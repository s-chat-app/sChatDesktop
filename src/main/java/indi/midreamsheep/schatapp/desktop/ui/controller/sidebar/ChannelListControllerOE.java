package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;
import lombok.Getter;

@Comment
@Getter
public class ChannelListControllerOE {

    private final Observable<ChannelListControllerFun> chatChannelObservable;
    private ObservableEmitter<ChannelListControllerFun> chatChannelObservableEmitter;

    @Injector
    public ChannelListControllerOE() {
        chatChannelObservable = Observable.create(emitter -> {
            chatChannelObservableEmitter = emitter;
        });
    }
}
