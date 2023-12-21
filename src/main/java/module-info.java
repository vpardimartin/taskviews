module com.example.carts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carts to javafx.fxml;
    exports com.example.carts;
}