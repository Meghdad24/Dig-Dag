package com.personal.graphic.game.digdag.objects;

public class Void extends GameObject {

    public Void(int rowIndex, int columnIndex) {
        super("file:src/main/resources/bricks/empty.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        //nothing
    }
}
