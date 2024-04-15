module com.example.javafxdemo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens views to javafx.fxml;
    exports views;
}