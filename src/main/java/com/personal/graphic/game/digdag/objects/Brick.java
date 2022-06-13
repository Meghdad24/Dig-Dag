package com.personal.graphic.game.digdag.objects;

public class Brick extends GameObject {


    public Brick() {
        super("file:src/main/resources/bricks/yello-brick2.png");
    }

    public Brick( int rowIndex, int columnIndex) {
        super("file:src/main/resources/bricks/yello-brick2.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        //nothing
    }
}
