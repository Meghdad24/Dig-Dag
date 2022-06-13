package com.personal.graphic.game.digdag.graphic;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class StopWatch extends Label {
    private int min = 0;
    private int sec = 0;
    private Timeline stopwatch;

    public StopWatch() {
        setText(min + ":" + sec);
        setFont(Font.font("verdana", FontWeight.BOLD, 30));
        ourTimeline();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopwatch.play();
    }

    public Timeline getStopwatch() {
        return stopwatch;
    }

    private void ourTimeline() {
        stopwatch = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            sec++;
            changeSecToMin();
            setText(min + ":" + sec);
        }));
        stopwatch.setCycleCount(Animation.INDEFINITE);
    }

    private void changeSecToMin() {
        if (sec == 60) {
            min++;
            sec = 0;
        }
    }


}
