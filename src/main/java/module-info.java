module com.example.rock_paper_scissors {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rock_paper_scissors to javafx.fxml;
    exports com.example.rock_paper_scissors;
}