package com.personal.graphic.game.digdag.objects.stuff;

import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.character.DigDag;

public class Sniper extends Stuff {
    public Sniper() {
        super("file:src/main/resources/assets/gun.png");
    }

    public Sniper(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/gun.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        if (current instanceof DigDag) {
            ((DigDag) current).getGun().setPower(((DigDag) current).getGun().getPower() + 2);
        }
    }
}
