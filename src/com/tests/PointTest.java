package com.tests;

import com.company.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class PointTest {

    @Test
    public void leavingBoardCount(){
        Point point = new Point( 0, 0);
        point.setX(31);
        point.setY(31);
        
        assertEquals(point.x, 0);
        assertEquals(point.x, 0);
    }
    
    @Test
    public void leavingBoard(){
        Point point = new Point( 0, 0 );
        point.setX(-1);
        point.setY(-1);
        
        assertEquals(point.x, 29);
        assertEquals(point.y, 29);
    }
    
    
    
    
}