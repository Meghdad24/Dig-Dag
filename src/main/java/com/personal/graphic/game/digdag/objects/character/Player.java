package com.personal.graphic.game.digdag.objects.character;

import com.personal.graphic.game.digdag.graphic.scenes.GamePage;

import java.io.Serializable;

public class Player implements Serializable {
    private Character character;
    private final String name;
    private int currentScore = 0;
    private int bestScore = 0;
    private int countsOfPlay = 0;

    public Player(String name) {
        this.name = name;
    }

    public void setCharacter(GamePage scene, int rowIndex, int columnIndex) {
        this.character = new DigDag(scene, rowIndex, columnIndex);
    }

    public Character getCharacter() {
        return character;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getCountsOfPlay() {
        return countsOfPlay;
    }

    public void setCountsOfPlay(int countsOfPlay) {
        this.countsOfPlay = countsOfPlay;
    }

    public void changeScore(int num) {
        currentScore += num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "|" + name + "|" +
                "\t|BestScore:" + bestScore + "|" +
                "\t|CountsOfPlay:" + countsOfPlay + "|";
    }
}
