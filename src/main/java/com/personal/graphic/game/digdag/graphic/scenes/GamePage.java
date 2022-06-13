package com.personal.graphic.game.digdag.graphic.scenes;

import com.personal.graphic.game.digdag.graphic.MapParser;
import com.personal.graphic.game.digdag.graphic.StopWatch;
import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.objects.character.DigDag;
import com.personal.graphic.game.digdag.objects.character.Player;
import com.personal.graphic.game.digdag.objects.stuff.Heart;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class GamePage extends Scene {
    private final Label pauseLabel = new Label("PAUSE");
    private MapParser mapParser;
    private Player player;
    private boolean isPause = false;

    private Timeline update;
    private Timeline exitChecker;
    private Timeline updateScore;
    private final StopWatch stopWatch = new StopWatch();


    public GamePage(Player player) {
        super(new Pane(), 800, 600);
        this.player = player;
        this.player.setCharacter(this, 5, 5);
        pauseLabel.setFont(Font.font("verdana", FontWeight.BOLD, 80));
        this.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
                exit();
            } else if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (isPause) {
                    resume();
                } else {
                    pause();
                }
            }
        });

        this.mapParser = new MapParser(player);
        System.out.println(player);
        setRoot(setMap());
        mapUpdateThread();
    }

    private void exit() {
        update.stop();
        updateScore.stop();
        stopWatch.getStopwatch().stop();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Global.MAIN_STAGE.setScene(MenuScene.getInstance());
    }


    private void pause() {
        isPause = true;
        update.pause();
        updateScore.pause();
        stopWatch.getStopwatch().pause();
        this.setRoot(new StackPane(pauseLabel));
    }

    private void resume() {
        isPause = false;
        update.play();
        updateScore.play();
        stopWatch.getStopwatch().play();
    }

    private Parent setMap() {
        AnchorPane information = new AnchorPane();
        initializeAnchor(information);
        HBox output = new HBox(mapParser.parseUpdatedGridPane(), information);
        return output;
    }

    public Player getPlayer() {
        return player;
    }

    public MapParser getMapParser() {
        return mapParser;
    }

    public void mapUpdateThread() {
        update = new Timeline(new KeyFrame(Duration.millis(80), actionEvent -> {
            if (!player.getCharacter().isAlive()) {
                exit();
            }
            mapParser.updateArray();
            Platform.runLater(() -> setRoot(setMap()));
        }));
        update.setCycleCount(Animation.INDEFINITE);
        update.play();
    }

    private void initializeAnchor(AnchorPane anchorPane) {
        HBox hearts = new HBox();
        hearts.setSpacing(10);
        hearts.setLayoutX(10);
        hearts.setLayoutY(10);
        for (int i = 0; i < ((DigDag) player.getCharacter()).getHealth(); i++) {
            hearts.getChildren().add(new Heart());
        }

        Label score = new Label(player.getName() + "\nScore: " + player.getCurrentScore());
        score.setFont(Font.font("verdana", FontWeight.BOLD, 10));

        updateScore = new Timeline(new KeyFrame(Duration.millis(80), actionEvent -> score.setText("Score: " + player.getCurrentScore())));
        updateScore.setCycleCount(Animation.INDEFINITE);
        updateScore.play();

        VBox vBox = new VBox(hearts, score);
        vBox.setSpacing(10);
        vBox.setLayoutX(10);
        vBox.setLayoutY(10);

        stopWatch.setLayoutX(10);
        stopWatch.setLayoutY(500);

        Label bstScore = new Label(player.getBestScore() + "");
        bstScore.setFont(Font.font("verdana", FontWeight.BOLD, 20));

        bstScore.setLayoutX(10);
        bstScore.setLayoutY(200);

        anchorPane.getChildren().addAll(vBox, stopWatch, bstScore);
    }
}
