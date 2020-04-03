package org.laborator7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    Player player1 = new Player("Maria");
    Player player2 = new Player("Ion");
    Player player3 = new Player("Andrei");
    List<Player> playerList = new ArrayList(Arrays.asList(player1,player2,player3));
    Game game = new Game(10,20,playerList);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
