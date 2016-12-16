package com.company;

/**
 * author @pater
 */
public class Board {
    
    private Char[][] board;
    private int size;
    public int numberOfCharsOnBoard;

    public void createNewBoard(int size) {
        this.size = size;
        this.numberOfCharsOnBoard = 0;
        this.board = new Char[size][size];
        
        fillTable0();
    }

    private void fillTable0() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = null;
            }
        }
    }

    public Char get(int x, int y) {
        return board[x][y];
    }
    
    public void setToRandomEmptyPlace(Char kid) {
        if(emptyPlaces() == 0) return;
        
        Point point = new Point(0,0);
        while( board[point.x][point.y] != null )
            point.generateRandomPosition(size);
            
        board[point.x][point.y] = kid;
        numberOfCharsOnBoard++;
    }

    private int emptyPlaces() {
        int count = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j] == null) ++count;
            }
        }
        return count;
    }
}
