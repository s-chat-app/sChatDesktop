package indi.midreamsheep.schatapp.desktop.service.command;

public class SChatCommandment {

    private static final SChatCommandment instance0 = new SChatCommandment();
    private static final SChatCommandment instance1 = new SChatCommandment();


    public static SChatCommandment getInstance(SChatCommandment instance) {
        return instance==instance0?instance1:instance0;
    }

    public static SChatCommandment getInstance() {
        return instance0;
    }

}
