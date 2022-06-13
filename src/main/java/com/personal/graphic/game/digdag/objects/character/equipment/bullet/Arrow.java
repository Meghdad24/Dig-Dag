package com.personal.graphic.game.digdag.objects.character.equipment.bullet;


import com.personal.graphic.game.digdag.objects.GameObject;
import com.personal.graphic.game.digdag.objects.character.Character;

public class Arrow extends Bullet{

    public Arrow() {
        super("file:src/main/resources/assets/objects/player/throw-rope-end.png");
    }

    public Arrow(int rowIndex, int columnIndex) {
        super("file:src/main/resources/assets/objects/player/throw-rope-end.png", rowIndex, columnIndex);
    }

    @Override
    public void setEffect(GameObject current) {
        if (current instanceof Character) {
            //todo: Animation of dead for balloons
            current.die();
        }
    }
}
