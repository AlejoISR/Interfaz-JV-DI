module com.example.altum {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.altum to javafx.fxml;
    exports com.example.altum;
}