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
    
    @Test
    public void ShouldBeEmptyAfterMove(){
        Board board = new Board();
        board.createNewBoard(10);
        
        Kid kid = new Kid();
        Point point = board.setToRandomEmptyPlace(kid);
        kid.moveLeft();

        assertEquals( board.get(point), kid);
        board.clearPosition( point );
        assertEquals( board.get(point), null);
    }
    
    /*
           board.clearPosition(this.position);
        this.position.setX(this.position.x + dx);
        this.position.setY(this.position.y + dy);
        board.takeThePosition(this);
     */
    
    @Test
    public void AfterMovingShouldTakeThePosition(){
        Board board = new Board();
        board.createNewBoard(30);
        
        Kid kid = new Kid();
        Point point = board.setToRandomEmptyPlace(kid);
        kid.setPosition(point);
        
        board.takeThePosition(kid);
        assertEquals(board.get(kid.position), kid);
        
        kid.setPosition(new Point(5,4));
        
        board.takeThePosition(kid);
        assertEquals(board.get(kid.position), kid);
    }
}