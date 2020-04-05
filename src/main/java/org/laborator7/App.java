package org.laborator7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Player player1 = new Player("Maria",1);
        Player player2 = new Player("Ion",2);
        Game game = new Game(player1,player2,3);
    }
}
