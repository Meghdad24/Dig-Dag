package com.personal.graphic.game.digdag.objects.character;

import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.objects.Attackable;
import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.Movable;
import com.personal.graphic.game.digdag.objects.Rock;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.HashMap;

/**
 * <p style:"color= Orange">
 * <b>
 *     Compelete
 * </b>
 * </p>
 * <p>
 *     This abstract class is parent of all character of our game.
 * <br>
 *     Anytime if you want to add a character to game you should extend <b>Character</b>
 * </p>
 *
 * @author Ramezani
 */
public abstract class Character extends GameObject implements Serializable, Movable, Attackable {
    private int speed = 1;

//    private int health; in this game just player has health!

    private HashMap<String, Image> setOfImages = new HashMap<>();
    private Image currentImage;

    public Character(String imagePath, int rowIndex, int columnIndex) {
        super(imagePath, rowIndex, columnIndex);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
            return;
        } else if (speed > Global.MAX_SPEED) {
            this.speed = Global.MAX_SPEED;
            return;
        }
        this.speed = speed;
    }

    public HashMap<String, Image> getSetOfImages() {
        return new HashMap<>(setOfImages);
    }

    public void addImageToImageList(String imagePath, String name) {
        setOfImages.put(name, new Image(imagePath));
    }

    @Override
    public void goUp(GameObject upObject) {
        if (!(upObject instanceof Rock)) {
            setColumnIndex(getColumnIndex() - speed);
            currentImage = setOfImages.get("run-up");
        }
    }

    @Override
    public void goDown(GameObject downObject) {
        if (!(downObject instanceof Rock)) {
            setColumnIndex(getColumnIndex() + speed);
            currentImage = setOfImages.get("run-down");
        }
    }

    @Override
    public void goRight(GameObject rightObject) {
        if (!(rightObject instanceof Rock)) {
            setRowIndex(getRowIndex() + speed);
            currentImage = setOfImages.get("run-right");
        }
    }

    @Override
    public void goLeft(GameObject leftObject) {
        if (!(leftObject instanceof Rock)) {
            setRowIndex(getRowIndex() - speed);
            currentImage = setOfImages.get("run-left");
        }
    }

    @Override
    public void stand() {
        currentImage = setOfImages.get("stand");
    }
}
