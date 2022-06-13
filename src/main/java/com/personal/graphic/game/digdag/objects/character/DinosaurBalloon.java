package com.personal.graphic.game.digdag.objects.character;

import com.personal.graphic.game.digdag.objects.GameObject;

public class DinosaurBalloon extends Enemy{
    public DinosaurBalloon(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/objects/balloon/dina-left.png", rowIndex, columnIndex);
    }

    @Override
    public void attack() {

    }

    @Override
    public void setEffect(GameObject current) {

    }

    @Override
    public void goUp(GameObject upObject) {
    }

    @Override
    public void goDown(GameObject downObject) {
    }

    @Override
    public void goRight(GameObject rightObject) {
    }

    @Override
    public void goLeft(GameObject leftObject) {
    }

    @Override
    public void stand() {

    }
}
