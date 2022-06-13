package com.personal.graphic.game.digdag.objects.character.equipment;

import com.personal.graphic.game.digdag.objects.character.equipment.bullet.Arrow;

public class Gun implements Abilitable {
    private Arrow bullet = new Arrow();
    private int power = 1;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void active() {
        fire();
    }

    private void fire() {
        System.out.println("FIRE!");
    }

}
