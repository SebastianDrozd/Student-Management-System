module SchoolSystem {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    exports loginapp;
    opens loginapp to javafx.fxml;
    exports Admin;
    opens Admin to javafx.fxml;
}