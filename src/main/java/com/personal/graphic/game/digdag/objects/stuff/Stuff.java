package com.personal.graphic.game.digdag.objects.stuff;

import com.personal.graphic.game.digdag.objects.GameObject;

public abstract class Stuff extends GameObject {
    public Stuff(String imagePath) {
        super(imagePath);
    }

    public Stuff(String imagePath, int rowIndex, int columnIndex) {
        super(imagePath, rowIndex, columnIndex);
    }
}
