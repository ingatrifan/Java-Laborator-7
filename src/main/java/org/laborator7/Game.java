package org.laborator7;

import javax.crypto.BadPaddingException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Game(int numberOfTokens,int intervalLimit, List<Player> players){
        board = new Board(numberOfTokens,intervalLimit);
        this.players = new ArrayList<>();
        this.players.addAll(players);
        for (Player player : players) {
            player.setBoard(this.board);
        }
        startGame();
    }
    private void startGame(){
        List<Thread> threads = new ArrayList<>();
        for (int iterator =0; iterator < players.size();iterator++){
            threads.add(new Thread(players.get(iterator)));
            threads.get(iterator).start();
        }
    }
}
