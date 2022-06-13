package com.personal.graphic.game.digdag.objects.character;

import com.personal.graphic.game.digdag.graphic.scenes.GamePage;
import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.character.equipment.Gun;
import javafx.scene.input.KeyCode;

public class DigDag extends Character {
    private final String[] imageMovePath = {
            "file:src/main/resources/assets/objects/player/stand-right.png",
            "file:src/main/resources/assets/objects/player/run-right.png",
            "file:src/main/resources/assets/objects/player/run-down.png",
            "file:src/main/resources/assets/objects/player/run-left.png",
            "file:src/main/resources/assets/objects/player/run-up.png",
    };
    private Gun gun = new Gun();
    private int health = Global.PLAYER_HEALTH;

    public DigDag(GamePage scene, int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/objects/player/stand-right.png", rowIndex, columnIndex);
        addImages();
        addActions(scene);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
            return;
        } else if (health > Global.MAX_HEALTH) {
            this.health = Global.MAX_HEALTH;
            return;
        }

        this.health = health;
    }

    public void damage(int power) {
        setHealth(getHealth() - power);
    }

    public Gun getGun() {
        return gun;
    }

    @Override
    public void attack() {
        gun.active();
    }

    @Override
    public void setEffect(GameObject current) {
        //nothing
    }

    private void addImages() {
        addImageToImageList(imageMovePath[0], "stand");
        addImageToImageList(imageMovePath[1], "run-right");
        addImageToImageList(imageMovePath[2], "run-down");
        addImageToImageList(imageMovePath[3], "run-left");
        addImageToImageList(imageMovePath[4], "run-up");
    }

    private void addActions(GamePage scene) {
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.UP)) {


                setImage(getSetOfImages().get("run-up"));
                if (getColumnIndex() > 0) {
                    goUp(scene.getMapParser().getObjectedMap()[getColumnIndex() - 1][getRowIndex()]);
                }
                System.out.println(getColumnIndex());


            } else if (keyEvent.getCode().equals(KeyCode.LEFT)) {


                setImage(getSetOfImages().get("run-left"));
                if (getRowIndex() > 0) {
                    goLeft(scene.getMapParser().getObjectedMap()[getColumnIndex()][getRowIndex() - 1]);
                }
                System.out.println(getRowIndex());


            } else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {


                setImage(getSetOfImages().get("run-right"));
                if (getRowIndex() < 11) {
                    goRight(scene.getMapParser().getObjectedMap()[getColumnIndex()][getRowIndex() + 1]);
                }
                System.out.println(getRowIndex());


            } else if (keyEvent.getCode().equals(KeyCode.DOWN)) {


                setImage(getSetOfImages().get("run-down"));
                if (getColumnIndex() < 11) {
                    goDown(scene.getMapParser().getObjectedMap()[getColumnIndex() + 1][getRowIndex()]);
                }
                System.out.println(getColumnIndex());


            } else if (keyEvent.getCode().equals(KeyCode.SPACE)) {

                attack();

            }
        });

        this.setOnKeyReleased(keyEvent -> setImage(getSetOfImages().get("stand")));
    }
}
