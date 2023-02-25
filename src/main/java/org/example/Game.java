package org.example;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public Player isRegister(String name) {
        for (Player player : playerList) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = this.isRegister(playerName1);
        Player player2 = this.isRegister(playerName2);
        if (player1 == null) {
            NotRegisterException e = new NotRegisterException(
                    "Name не найден:" + playerName1
            );
            throw e;
        }
        if (player2 == null) {
            NotRegisterException e = new NotRegisterException(
                    "Name не найден:" + playerName2
            );
            throw e;
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
