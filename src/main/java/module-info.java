module com.example.spinwheelproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spinwheelproject to javafx.fxml;
    exports com.example.spinwheelproject;
}