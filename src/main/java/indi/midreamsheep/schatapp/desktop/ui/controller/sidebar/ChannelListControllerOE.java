package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar.SubSideBarFun;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;
import lombok.Getter;

@Comment
@Getter
public class ChannelListControllerOE {

    private final Observable<SubSideBarFun> chatChannelObservable;
    private ObservableEmitter<SubSideBarFun> chatChannelObservableEmitter;

    @Injector
    public ChannelListControllerOE() {
        chatChannelObservable = Observable.create(emitter -> {
            chatChannelObservableEmitter = emitter;
        });
    }
}
