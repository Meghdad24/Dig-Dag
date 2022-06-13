package com.personal.graphic.game.digdag.helper;


import com.personal.graphic.game.digdag.objects.character.Player;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;

public class Global {
    public final static double WIDTH = 800;
    public final static double HEIGHT = 600;
    public final static Stage MAIN_STAGE = new Stage();
    public final static Font PIXELATE = Font.loadFont("file:src/main/resources/font/Connection-arMJ.otf", 20);
    public final static Font PIXELATE2 = Font.loadFont("file:src/main/resources/font/AtariClassicExtrasmooth-LxZy.ttf", 20);
    public final static HashMap<String, Player> PLAYER_LIST = new HashMap<>();
    public final static int FLOWER_SCORE = 500;
    public final static int PLAYER_HEALTH = 3;
    public static final int MAX_HEALTH = 4;
    public static final int MAX_SPEED = 2;
    public static final int BLOCK_SIZE = 50;
    public static final int MAP_SIZE = 12;
    public static final int FIRE_POWER = 1;
}
