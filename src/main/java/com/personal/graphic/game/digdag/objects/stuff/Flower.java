package com.personal.graphic.game.digdag.objects.stuff;

import com.personal.graphic.game.digdag.objects.GameObject;

public class Flower extends GameObject {
    public Flower() {
        super("file:src/main/resources/assets/objects/flower.png");
    }

    public Flower(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/objects/flower.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {

    }
}
