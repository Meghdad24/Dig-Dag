package com.personal.graphic.game.digdag.objects;

import com.personal.graphic.game.digdag.objects.character.*;
import com.personal.graphic.game.digdag.objects.character.equipment.bullet.Bullet;
import com.personal.graphic.game.digdag.objects.stuff.Stuff;
import com.personal.graphic.game.digdag.objects.character.Character;

public class CollideObject {
    public static void collide(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 instanceof Stuff && gameObject2 instanceof DigDag) {
            gameObject1.setEffect(gameObject2);
            return;
        } else if (gameObject2 instanceof Stuff && gameObject1 instanceof DigDag) {
            gameObject2.setEffect(gameObject1);
            return;
        }

        if (gameObject1 instanceof Brick) {
            gameObject1.die();
        } else if (gameObject2 instanceof Brick) {
            gameObject2.die();
        }

        if (gameObject1 instanceof Bullet && gameObject2 instanceof Character) {
            gameObject1.setEffect(gameObject2);
        } else if (gameObject2 instanceof Bullet && gameObject1 instanceof Character) {
            gameObject2.setEffect(gameObject1);
        }


    }
}
