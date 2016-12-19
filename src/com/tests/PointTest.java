package com.tests;

import com.company.Configuration;
import com.company.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class PointTest {

  
    @Test
    public void xIsBiggerThanRange(){
        Point point = new Point(0,0);
        point.setX( Configuration.BOARD_SIZE );
        assertEquals(0, point.x);
    }
    
    @Test
    public void isSmallerThanRange(){
        Point point = new Point(0,0);
        point.setX(-1);
        assertEquals(Configuration.BOARD_SIZE-1, point.x);
    }
    
    @Test
    public void inCorner(){
        Point point = new Point(0,0);
        point.setX( 10*Configuration.BOARD_SIZE + 1 );
        assertEquals(0, point.x);
    }
}