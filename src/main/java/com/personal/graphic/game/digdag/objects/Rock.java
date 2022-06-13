package com.personal.graphic.game.digdag.objects;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import com.personal.graphic.game.digdag.objects.character.Character;

public class Rock extends GameObject {
    private GameObject downObj;

    public Rock(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/objects/rock.png", rowIndex, columnIndex);
        makeFallingTimeline();
    }

    public void setDownObj(GameObject downObj) {
        this.downObj = downObj;
    }

    @Override
    public void setEffect(GameObject current) {
        current.die();
    }

    private void makeFallingTimeline() {
        Timeline fallout = new Timeline(new KeyFrame(Duration.millis(500), actionEvent -> {
            if (downObj instanceof Void) {
                setColumnIndex(getColumnIndex() + 1);
            } else if (downObj instanceof Character) {
                setEffect(downObj);
                setColumnIndex(getColumnIndex() + 1);
            }
        }));
        fallout.setCycleCount(Animation.INDEFINITE);
        fallout.play();
    }
}
