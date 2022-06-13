package com.personal.graphic.game.digdag.objects.character.equipment.bullet;

import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.character.DigDag;

public class Fire extends Bullet{
    public Fire(String imagePath) {
        super(imagePath);
    }

    public Fire(String imagePath, int rowIndex, int columnIndex) {
        super(imagePath, rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        if (current instanceof DigDag) {
            ((DigDag) current).damage(Global.FIRE_POWER);
        }
    }
}
