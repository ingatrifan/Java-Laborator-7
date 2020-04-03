package org.laborator7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    List<Token> tokens;
    private String name;
    private Board board;
    Player(String name){
        this.name=name;
        this.tokens = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void extractToken(){
       tokens.add(board.getLastToken());
       System.out.printf("%s - %d",name,board.getLastToken().getToken());
       board.removeToken();
    }

    @Override
    public void run() {
        extractToken();
    }
}
