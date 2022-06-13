package com.personal.graphic.game.digdag.graphic.scenes;

import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.objects.character.Player;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoadGameScene extends Scene {
    private final String backImagePath = "file:src/main/resources/background/281303a9bbc5eb8.png";

    public LoadGameScene() {
        super(new Pane(), Global.WIDTH, Global.HEIGHT);
        setRoot(getLoadGameSceneRoot());
    }

    private Parent getLoadGameSceneRoot() {
        ImageView back = new ImageView(new Image(backImagePath));
        back.setPreserveRatio(true);
        back.setFitWidth(930);

        VBox vBox = new VBox();
        addPlayers(vBox);
        vBox.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setPrefSize(100, 100);
        scrollPane.setMaxHeight(400);
        scrollPane.setMaxWidth(600);

        StackPane output = new StackPane(back, scrollPane);
        StackPane.setAlignment(scrollPane, Pos.CENTER);
        StackPane.setAlignment(back, Pos.CENTER);

        return output;
    }

    private void addPlayers(VBox current) {
        Button[] players = new Button[Global.PLAYER_LIST.size()];
        int i = 0;
        for (Player p : Global.PLAYER_LIST.values()) {
            players[i] = new Button(p.toString());
            players[i].setFont(Font.font("connection", FontWeight.BOLD, 20));
            players[i].setPrefSize(600, 100);
            players[i].setOnMousePressed(mouseEvent -> Global.MAIN_STAGE.setScene(new GamePage(Global.PLAYER_LIST.get(p.getName()))));
            current.getChildren().add(players[i]);
            i++;
        }
    }
}
