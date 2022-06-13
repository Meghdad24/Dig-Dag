package com.personal.graphic.game.digdag.objects.character.equipment.bullet;

import com.personal.graphic.game.digdag.objects.GameObject;

public abstract class Bullet extends GameObject {
    public Bullet(String imagePath) {
        super(imagePath);
    }

    public Bullet(String imagePath, int rowIndex, int columnIndex) {
        super(imagePath, rowIndex, columnIndex);
    }
}
