package com.personal.graphic.game.digdag.graphic.scenes;

import com.personal.graphic.game.digdag.helper.Global;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuScene extends Scene {
    private static MenuScene instance;

    private final String backImagePath = "file:src/main/resources/background/281303a9bbc5eb8.png";

    private final String borderImagePath = "file:src/main/resources/background/border.png";

    private String[] newGameImagePaths = {
            "file:src/main/resources/buttons/new-game-normal.png",
            "file:src/main/resources/buttons/new-game-mouse-on-it.png",
            "file:src/main/resources/buttons/new-game-pressed.png"
    };

    private String[] loadGameImagePaths = {
            "file:src/main/resources/buttons/load-game-normal.png",
            "file:src/main/resources/buttons/load-game-mouse-on-it.png",
            "file:src/main/resources/buttons/load-game-pressed.png"
    };

    private String[] quiteImagePaths = {
            "file:src/main/resources/buttons/quite-normal.png",
            "file:src/main/resources/buttons/quite-mouse-on-it.png",
            "file:src/main/resources/buttons/quite-pressed.png"
    };

    private MenuScene() {
        super(new Pane(), Global.WIDTH, Global.HEIGHT);
        setRoot(getMenuSceneRoot());
    }

    public static MenuScene getInstance() {
        if (instance==null) {
            instance = new MenuScene();
        }
        return instance;
    }

    private Parent getMenuSceneRoot() {
        ImageView back = new ImageView(new Image(backImagePath));
        back.setPreserveRatio(true);
        back.setFitWidth(930);

        ImageView border = new ImageView( new Image(borderImagePath));

        VBox menu = new VBox();
        addButtons(menu);

        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(30);

        StackPane output = new StackPane(back, border, menu);
        StackPane.setAlignment(back, Pos.CENTER);
        StackPane.setAlignment(border, Pos.CENTER);
        StackPane.setAlignment(menu, Pos.CENTER);

        return output;
    }

    private void addButtons(VBox currentPane) {
        Image newGameNormal = new Image(newGameImagePaths[0]);
        Image newGameMouseOnIt = new Image(newGameImagePaths[1]);
        Image newGamePressed = new Image(newGameImagePaths[2]);

        Image loadGameNormal = new Image(loadGameImagePaths[0]);
        Image loadGameMouseOnIt = new Image(loadGameImagePaths[1]);
        Image loadGamePressed = new Image(loadGameImagePaths[2]);

        Image quiteNormal = new Image(quiteImagePaths[0]);
        Image quiteMouseOnIt = new Image(quiteImagePaths[1]);
        Image quitePressed = new Image(quiteImagePaths[2]);

        ImageView newGameButton = new ImageView(newGameNormal);
        setGraphicOfButton(newGameButton, newGameNormal, newGameMouseOnIt, newGamePressed);
        newGameButton.setOnMouseClicked(event -> Global.MAIN_STAGE.setScene(NewGameScene.getInstance()));

        ImageView loadGameButton = new ImageView(loadGameNormal);
        setGraphicOfButton(loadGameButton, loadGameNormal, loadGameMouseOnIt, loadGamePressed);
        loadGameButton.setOnMouseClicked(event -> Global.MAIN_STAGE.setScene(new LoadGameScene()));

        ImageView quiteButton = new ImageView(quiteNormal);
        setGraphicOfButton(quiteButton, quiteNormal, quiteMouseOnIt, quitePressed);
        quiteButton.setOnMouseClicked(event -> Global.MAIN_STAGE.close());

        StackPane imageNewGame = new StackPane(newGameButton);
        imageNewGame.setMinSize(100,60);
        imageNewGame.setMaxSize(100,60);

        StackPane imageLoadGame = new StackPane(loadGameButton);
        imageLoadGame.setMinSize(100,60);
        imageLoadGame.setMaxSize(100,60);

        StackPane imageQuite = new StackPane(quiteButton);
        imageQuite.setMinSize(100,60);
        imageQuite.setMaxSize(100,60);

        currentPane.getChildren().addAll(imageNewGame, imageLoadGame, imageQuite);
    }

    private void setGraphicOfButton(ImageView current, Image normal, Image mouseOnIt, Image pressed) {
        current.setOnMouseEntered(event -> current.setImage(mouseOnIt));
        current.setOnMouseExited(event -> current.setImage(normal));
        current.setOnMousePressed(event -> current.setImage(pressed));
        current.setOnMouseReleased(event -> current.setImage(normal));
    }
}
