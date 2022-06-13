package com.personal.graphic.game.digdag.helper;


import com.personal.graphic.game.digdag.objects.character.Player;

import java.io.*;
import java.util.HashMap;

public class Save {

    public static void savePlayer(Player currentPlayer) throws IOException {
        Global.PLAYER_LIST.put(currentPlayer.getName(), currentPlayer);
        FileOutputStream fileOutputStream = new FileOutputStream("Save/Player.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(Global.PLAYER_LIST);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static HashMap<String, Player> getPlayers() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Save/Player.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<String, Player> playerHashMap = (HashMap<String, Player>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return playerHashMap;
    }

    public static void loadPlayers() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Save/Player.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Global.PLAYER_LIST.putAll((HashMap<String, Player>) objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
    }


}
