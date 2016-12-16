package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class BoardTest {

    @Test
    public void ShouldBeEmpty(){
        Board board = new Board();
        board.createNewBoard(10);
        assertEquals(board.get(1,1), 0);
    }
    
    @Test
    public void CornerShouldBeEmpty(){
        Board board = new Board();
        board.createNewBoard(10);
        assertEquals(board.get(9,9), 0);
    }

}