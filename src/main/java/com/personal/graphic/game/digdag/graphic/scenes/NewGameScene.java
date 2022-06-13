package com.personal.graphic.game.digdag.graphic.scenes;

import com.personal.graphic.game.digdag.helper.*;
import com.personal.graphic.game.digdag.objects.character.Player;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

public class NewGameScene extends Scene {
    private static NewGameScene instance;

    private final String backImagePath = "file:src/main/resources/background/281303a9bbc5eb8.png";

    private NewGameScene() {
        super(new Pane(), Global.WIDTH, Global.HEIGHT);
        setRoot(getNewGameSceneRoot());
    }

    public static NewGameScene getInstance() {
        if (instance==null) {
            instance = new NewGameScene();
        }
        return instance;
    }

    private Parent getNewGameSceneRoot() {
        ImageView back = new ImageView(new Image(backImagePath));
        back.setPreserveRatio(true);
        back.setFitWidth(930);

        TextField enterName = makeTextField();

        Label errorForRepeatedName = makeLabel();

        Button submit = makeButton(enterName, errorForRepeatedName);

        HBox topOfMenu = new HBox(submit, enterName);
        topOfMenu.setSpacing(10);
        topOfMenu.setAlignment(Pos.CENTER);

        GridPane menu = new GridPane();
        menu.setVgap(7);
        menu.add(topOfMenu, 0,0);
        menu.add(errorForRepeatedName, 0,1);
        menu.setAlignment(Pos.CENTER);
        GridPane.setHalignment(errorForRepeatedName, HPos.LEFT);

        StackPane output = new StackPane(back, menu);
        StackPane.setAlignment(back, Pos.CENTER);
        StackPane.setAlignment(menu, Pos.CENTER);
        return output;
    }

    private TextField makeTextField() {
        TextField enterName = new TextField();
        enterName.setPrefSize(400, 70);
        enterName.setMaxSize(400, 70);
        enterName.setPromptText("Enter your name...");
        enterName.setFont(Font.font("connection", FontWeight.BOLD, 30));
        return enterName;
    }

    private Label makeLabel() {
        Label errorForRepeatedName = new Label("");
        errorForRepeatedName.setTextFill(Color.RED);
        errorForRepeatedName.setStyle("-fx-font-family: connection; -fx-font-weight: bold; -fx-font-size: 20");
        return errorForRepeatedName;
    }

    private Button makeButton(TextField enterName, Label errorForRepeatedName) {
        Button submit = new Button("Submit");
        submit.setPrefHeight(70);
        submit.setStyle("-fx-font-family: connection; -fx-font-weight: bold; -fx-font-size: 20;");
        submit.setOnMouseClicked(event -> {
            if (Global.PLAYER_LIST.containsKey(enterName.getText())) {
                errorForRepeatedName.setText("This name have been exist!");
            } else if (enterName.getText().length() < 3) {
                errorForRepeatedName.setText("The name should be more than 2 letters!");
            } else {
                try {
                    Save.savePlayer(new Player(enterName.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Global.MAIN_STAGE.setScene(new GamePage(Global.PLAYER_LIST.get(enterName.getText())));
            }
        });
        return submit;
    }
}
