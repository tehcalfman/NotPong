module com.example.oop_assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_assignment1 to javafx.fxml;
    exports com.example.oop_assignment1;
    exports com.example.oop_assignment1.controller;
    opens com.example.oop_assignment1.controller to javafx.fxml;
    exports com.example.oop_assignment1.model;
    opens com.example.oop_assignment1.model to javafx.fxml;
}