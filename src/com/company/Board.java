package com.company;

/**
 * author @pater
 */
public class Board {
    
    private int[][] board;
    private int size;
    private static Board ourInstance = new Board();

    public void createNewBoard(int size) {
        this.size = size;
        board = new int[size][size];
        
        fillTable0();
    }

    private void fillTable0() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static Board getInstance() {
        return ourInstance;
    }


    public int get(int x, int y) {
        return board[x][y];
    }
}
