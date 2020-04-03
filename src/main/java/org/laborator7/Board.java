package org.laborator7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private int size;
    private int intervalLimit;
    private List<Token> tokenList;

    Board(int size,int interval){
        tokenList = new ArrayList<>();
        this.size=size;
        this.intervalLimit = interval;
        generateTokens();
    }
    public List<Token> getTokenList() {
        return tokenList;
    }
    public void generateTokens(){
        int interval[] = new int[intervalLimit];
        for (int iterator = 0;iterator<intervalLimit;iterator++){
            interval[iterator]=0;
        }
        while(tokenList.size() != size ){
            Random random = new Random();
            int randNumber = random.nextInt(intervalLimit);
            if (interval[randNumber] == 0){
                interval[randNumber] = 1;
                Token token = new Token(randNumber);
                tokenList.add(token);
            }
        }
    }

    public void removeToken(){
        tokenList.remove(tokenList.size()-1);
    }
    public Token getLastToken(){
        return tokenList.get(tokenList.size()-1);
    }
}
