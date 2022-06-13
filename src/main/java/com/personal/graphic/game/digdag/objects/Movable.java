package com.personal.graphic.game.digdag.objects;

public interface Movable {
    void goUp(GameObject upObject);

    void goDown(GameObject downObject);

    void goRight(GameObject rightObject);

    void goLeft(GameObject leftObject);

    void stand();
}
