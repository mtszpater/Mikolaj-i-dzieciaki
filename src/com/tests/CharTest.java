package com.tests;

import com.company.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class CharTest {
    
    @Test
    public void ShouldReturnPathToImage(){
        Char kid = new Kid();
        assertEquals(kid.image, "../../images/kid.png");
    }
    
    @Test
    public void GetCurrentPosition(){
        Char kid = new Kid();
        kid.setPosition(new Point( 0,0 ));
        
        assertEquals(kid.position.x, 0);
        assertEquals(kid.position.y, 0);
    }
    
    @Test
    public void MoveLeft(){
        Char kid = new Kid();
        kid.setPosition( new Point (5,5) );
        
        kid.moveLeft();
        assertEquals( kid.position.x,  4);
        assertEquals( kid.position.y,  5);
    }

    @Test
    public void MoveRight(){
        Char kid = new Kid();
        kid.setPosition( new Point (5,5) );

        kid.moveRight();
        assertEquals( kid.position.x,  6);
        assertEquals( kid.position.y,  5);
    }

    @Test
    public void MoveUp(){
        Char kid = new Kid();
        kid.setPosition( new Point (5,5) );

        kid.moveUp();
        assertEquals( kid.position.x,  5);
        assertEquals( kid.position.y,  6);
    }

    @Test
    public void MoveDown(){
        Char kid = new Kid();
        kid.setPosition( new Point (5,5) );

        kid.moveDown();
        assertEquals( kid.position.x,  5);
        assertEquals( kid.position.y,  4);
    }
    
    
}