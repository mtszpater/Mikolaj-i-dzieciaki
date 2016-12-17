package com.tests;

import com.company.*;
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
        assertEquals(board.get(new Point(1,1)), null);
    }
    
    @Test
    public void CornerShouldBeEmpty(){
        Board board = new Board();
        board.createNewBoard(10);
        assertEquals(board.get(new Point(9,9)), null);
    }

    @Test
    public void SetToRandomFreePlace(){
        Board board = new Board();
        board.createNewBoard(20);
        Char kid = new Kid();
        board.setToRandomEmptyPlace( kid );
        assertEquals(board.numberOfCharsOnBoard, 1);
    }
    
    @Test
    public void AddCharAtBusyBoard(){
        Board board = new Board();
        board.createNewBoard(1);
        Char kid = new Kid();
        board.setToRandomEmptyPlace( kid );
        board.setToRandomEmptyPlace( kid );
        assertEquals(board.numberOfCharsOnBoard, 1);
    }
}