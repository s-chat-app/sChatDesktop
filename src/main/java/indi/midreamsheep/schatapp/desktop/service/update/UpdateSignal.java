package indi.midreamsheep.schatapp.desktop.service.update;

public class UpdateSignal {

    private static final UpdateSignal instance0 = new UpdateSignal();
    private static final UpdateSignal instance1 = new UpdateSignal();


    public static UpdateSignal getInstance(UpdateSignal instance) {
        return instance==instance0?instance1:instance0;
    }

    public static UpdateSignal getInstance() {
        return instance0;
    }

}
