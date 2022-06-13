package com.personal.graphic.game.digdag.objects.stuff;

import com.personal.graphic.game.digdag.objects.GameObject;

public class Skate extends Stuff {
    public Skate(String imagePath) {
        super(imagePath);
    }

    public Skate(String imagePath, int rowIndex, int columnIndex) {
        super(imagePath, rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {

    }
}
