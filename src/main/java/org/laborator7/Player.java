package org.laborator7;

import java.util.Random;

public class Player implements Runnable {
    private String name;
    private Board board;
    private Game game;
    private int order;
    private boolean running;

    Player(String name,int order){
        this.name=name;
        this.order = order;
        this.running = true;
    }
    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }
    public void setGame(Game game){
        this.game = game;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    private String makeMove(){
        Random random = new Random();
        int pozX,pozY;
        if (board.getAvailableCells().size()>0){
            int randomAvailableCell = random.nextInt(board.getAvailableCells().size());
            pozX = board.getAvailableCells().get(randomAvailableCell).getKey();
            pozY = board.getAvailableCells().get(randomAvailableCell).getValue();
            board.playerMove(pozX,pozY,order);
            return "Success";
        } return "Fail";
    }
    public void stopThread(){
        this.running =false;
    }
    @Override
    public void run() {
        System.out.printf("Player %d running\n",order);
        while (running) {
            String message = makeMove();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println("Caught:" + e);
            }
            if (message == "Fail"){
                try {
                    game.endGame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
