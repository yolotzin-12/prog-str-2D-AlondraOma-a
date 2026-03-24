module com.example.crudemer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.crudemer to javafx.fxml;
    exports com.example.crudemer;
}