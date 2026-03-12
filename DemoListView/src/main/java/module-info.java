module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolistview to javafx.fxml;
    opens com.example.demolistview.Controllers to javafx.fxml;
    opens com.example.demolistview.repositories to javafx.fxml;
    opens com.example.demolistview.Service to javafx.fxml;
    exports com.example.demolistview;
    exports com.example.demolistview.Controllers;
    exports com.example.demolistview.repositories;
    exports com.example.demolistview.Service;
}