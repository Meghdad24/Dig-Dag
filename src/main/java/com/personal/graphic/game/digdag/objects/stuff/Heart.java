package com.personal.graphic.game.digdag.objects.stuff;

import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.character.DigDag;

public class Heart extends Stuff{
    public Heart() {
        super("file:src/main/resources/assets/heart.png");
    }

    public Heart(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/heart.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        if (current instanceof DigDag) {
            ((DigDag) current).setHealth(((DigDag) current).getHealth() + 1);
        }
    }
}
