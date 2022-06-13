package com.personal.graphic.game.digdag.graphic.scenes;

import com.personal.graphic.game.digdag.helper.Global;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class StartScene extends Scene {
    private final String backImagePath = "file:src/main/resources/background/68744923-pixel-art-spel-ondergrondse-tunnel-achtergrond-met-vuil-en-gras.jpg";
    private final String titleImagePath = "file:src/main/resources/assets/Dig Dug.png";
    private boolean nextScene = false;

    public StartScene() {
        super(new Pane(), Global.WIDTH, Global.HEIGHT, Color.BLACK);
        super.setRoot(getStartSceneRoot());

        //Go nextPage
        this.setOnKeyPressed(event -> {
            this.setNextScene(true);

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Global.MAIN_STAGE.setScene(MenuScene.getInstance());
        });
    }

    public void setNextScene(boolean nextScene) {
        this.nextScene = nextScene;
    }

    private Pane getStartSceneRoot() {
        ImageView backGround = new ImageView(new Image(backImagePath));
        backGround.setPreserveRatio(true);
        backGround.setFitWidth(920);

        BorderPane bp = new BorderPane();

        bp.setCenter(setCenter());
        bp.setTop(setTop());
        bp.setBottom(setBottom());

        return new StackPane(backGround, bp);
    }

    private Node setCenter() {
        ImageView digDagLogo = new ImageView(new Image(titleImagePath));
        digDagLogo.setPreserveRatio(true);
        digDagLogo.setFitWidth(450);

        Text press = new Text("Press any key to play");
        press.setFont(Global.PIXELATE);
        press.setFill(Color.WHITE);
        press.setTextAlignment(TextAlignment.CENTER);

        addBlinkToText(press);

        VBox output = new VBox(digDagLogo, press);
        output.setPadding(new Insets(120, 0, 0, 0));
        output.setSpacing(145);
        output.setAlignment(Pos.TOP_CENTER);

        return output;
    }

    private Node setTop() {
        Text output = new Text("In the name of god");
        output.setFill(Color.WHITE);
        output.setTextAlignment(TextAlignment.CENTER);
        output.setFont(Global.PIXELATE);
        output.setStyle("-fx-font-size: 23");

        BorderPane.setMargin(output, new Insets(15, 0, 0, 0));
        BorderPane.setAlignment(output, Pos.CENTER);

        return output;
    }

    private Node setBottom() {
        Text kntu = new Text("KNTU.AC");
        BorderPane.setAlignment(kntu, Pos.BOTTOM_LEFT);
        BorderPane.setMargin(kntu, new Insets(0, 0, 7, 7));
        kntu.setFont(Global.PIXELATE2);
        return kntu;
    }

    private void addBlinkToText(Text current) {
        String txt = "Press any key to play";
        Thread wink = new Thread(() -> {
            while (!nextScene) {
                try {
                    Thread.sleep(500);
                    if (nextScene) {
                        break;
                    }
                    current.setText("");

                    Thread.sleep(500);
                    if (nextScene) {
                        break;
                    }
                    current.setText(txt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        wink.start();
    }
}
