module javafxCalculator {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    exports com.glebremniov.javafxCalculator.controller;
    opens com.glebremniov.javafxCalculator.controller;

    opens com.glebremniov.javafxCalculator;
}