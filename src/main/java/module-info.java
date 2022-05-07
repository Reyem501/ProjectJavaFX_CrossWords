module com.example.projectjavafx_crosswords {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectjavafx_crosswords to javafx.fxml;
    exports com.example.projectjavafx_crosswords;
}