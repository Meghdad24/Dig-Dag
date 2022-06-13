package com.personal.graphic.game.digdag.objects;

import com.personal.graphic.game.digdag.helper.Global;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <p style:"color= Orange">
 * <b>
 *     Compelete
 * </b>
 * </p>
 * <p>
 *     This abstract class is parent of all object of our game.
 * <br>
 *     Anytime if you want to add an object to game you should extend <b>GameObject</b>
 * </p>
 *
 * @author Ramezani
 */
public abstract class GameObject extends ImageView {
    private Image image;
    private int rowIndex;
    private int columnIndex;
    private boolean alive = true;
    private boolean visible = true;

    public GameObject(String imagePath) {
        this.image = new Image(imagePath);
        super.setImage(image);
        setFitWidth(Global.BLOCK_SIZE);
        setFitHeight(Global.BLOCK_SIZE);
    }

    public GameObject(String imagePath, int rowIndex, int columnIndex) {
        this.image = new Image(imagePath);
        super.setImage(image);
        setFitWidth(Global.BLOCK_SIZE);
        setFitHeight(Global.BLOCK_SIZE);
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public void setIndexes(int rowIndex, int columnIndex) {
        if (rowIndex<0) {
            rowIndex = 0;
        } else if (rowIndex>11) {
            rowIndex = 11;
        }

        if (columnIndex<0) {
            columnIndex = 0;
        } else if (columnIndex>11) {
            columnIndex = 11;
        }

        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        if (rowIndex<0) {
            rowIndex = 0;
        } else if (rowIndex>11) {
            rowIndex = 11;
        }

        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        if (columnIndex<0) {
            columnIndex = 0;
        } else if (columnIndex>11) {
            columnIndex = 11;
        }

        this.columnIndex = columnIndex;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        this.alive = false;
    }

    public boolean isVisibility() {
        return visible;
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
    }

    public boolean isCollide(GameObject gameObject) {
        return (rowIndex == gameObject.rowIndex && columnIndex == gameObject.columnIndex);
    }

    public abstract void setEffect(GameObject current);
}
