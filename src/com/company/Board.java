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
        fillTable();
    }

    private void fillTable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = null;
            }
        }
    }

    public Char get(Point point) {
        return board[point.x][point.y];
    }
    
    public Point setToRandomEmptyPlace(Char kid) {
        if(emptyPlaces() == 0) return null;
        
        Point point = new Point(0,0);
        while( board[point.x][point.y] != null )
            point = RandomPointer.generateRandomPoint(Configuration.BOARD_SIZE);
            
        board[point.x][point.y] = kid;
        numberOfCharsOnBoard++;
        
        return point;
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
