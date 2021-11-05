module com.personal.graphic.game.digdag {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.personal.graphic.game.digdag to javafx.fxml;
    exports com.personal.graphic.game.digdag;
}