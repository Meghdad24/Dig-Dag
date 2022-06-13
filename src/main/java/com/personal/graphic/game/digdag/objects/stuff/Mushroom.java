package com.personal.graphic.game.digdag.objects.stuff;

import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.character.DigDag;

public class Mushroom extends Stuff {
    public Mushroom() {
        super("file:src/main/resources/assets/mushroom.png");
    }

    public Mushroom(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/mushroom.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        if (current instanceof DigDag) {
            ((DigDag) current).setSpeed(((DigDag) current).getSpeed() - 1);
        }
    }
}
