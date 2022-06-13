package com.personal.graphic.game.digdag.graphic;


import com.personal.graphic.game.digdag.helper.Global;
import com.personal.graphic.game.digdag.objects.*;
import com.personal.graphic.game.digdag.objects.Void;
import com.personal.graphic.game.digdag.objects.character.*;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapParser {
    private String[][] codedMap;
    private int mapSize;
    private GameObject[][] objectedMap;


    public MapParser(Player player) {
        this.mapSize = Global.MAP_SIZE;
        codedMap = new String[mapSize][mapSize];
        objectedMap = new GameObject[mapSize][mapSize];
        initializePrimarilyMap();
        initializeArrayMap(player);
    }

    private void initializePrimarilyMap() {
        try {
            FileReader fileReader = new FileReader("Save/map.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (int column = 0; column < mapSize; column++) {
                codedMap[column] = bufferedReader.readLine().split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeArrayMap(Player player) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                switch (codedMap[i][j]) {
                    case "b" -> objectedMap[i][j] = new Brick(j, i);
                    case "o" -> objectedMap[i][j] = new Void(j, i);
                    case "D" -> objectedMap[i][j] = new DinosaurBalloon(j, i);
                    case "B" -> objectedMap[i][j] = new RedBalloon(j, i);
                    case "r" -> objectedMap[i][j] = new Rock(j, i);
                    case "*" -> objectedMap[i][j] = player.getCharacter();
                }
            }
        }
    }

    public void updateArray() {
        int newI, newJ;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                newI = objectedMap[i][j].getColumnIndex();
                newJ = objectedMap[i][j].getRowIndex();
                if (newI == i && newJ == j) {
                    continue;
                }
                if (objectedMap[newI][newJ] instanceof Brick || objectedMap[newI][newJ] instanceof Void) {
                    objectedMap[newI][newJ] = objectedMap[i][j];
                    objectedMap[i][j] = new Void(j, i);
                }
            }

        }
    }

    public Parent parseUpdatedGridPane() {
        GridPane output = new GridPane();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                output.add(objectedMap[i][j], j, i);
                if (objectedMap[i][j] instanceof Rock && i<11) {
                    ((Rock) objectedMap[i][j]).setDownObj(objectedMap[i+1][j]);
                }
            }
        }
        return output;
    }

    public GameObject[][] getObjectedMap() {
        return objectedMap.clone();
    }
}
