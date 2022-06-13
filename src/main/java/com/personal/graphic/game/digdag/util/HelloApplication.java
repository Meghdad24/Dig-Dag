package com.personal.graphic.game.digdag.util;

import com.personal.graphic.game.digdag.graphic.scenes.StartScene;
import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.helper.Save;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    static {
        try {
            Save.loadPlayers();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Global.MAIN_STAGE.setResizable(false);
        Global.MAIN_STAGE.setScene(new StartScene());
        Global.MAIN_STAGE.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}