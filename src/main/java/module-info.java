module indi.midreamsheep.schatapp.desktop.schatdesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens indi.midreamsheep.schatapp.desktop.schatdesktop to javafx.fxml;
    exports indi.midreamsheep.schatapp.desktop.schatdesktop;
    exports indi.midreamsheep.schatapp.desktop.schatdesktop.account;
}