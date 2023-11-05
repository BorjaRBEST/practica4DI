module com.example.practica4di {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.desktop;


    opens com.example.practica4di to javafx.fxml;
    exports com.example.practica4di;
}