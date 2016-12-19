package com.tests;

import com.company.Point;
import com.company.characters.Kid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class KidTest {
    
    @Test
    public void moveRight(){
        Kid kid = new Kid();
        
        kid.setPosition(new Point(2,0));
        kid.moveRight();
        kid.move();
        
        assertEquals(kid.position.x, 3);
    }

    @Test
    public void moveLeft(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,0));
        kid.moveLeft();
        kid.move();

        assertEquals(kid.position.x, 1);
    }

    @Test
    public void moveDown(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,1));
        kid.moveDown();
        kid.move();

        assertEquals(kid.position.y, 0);
    }

    @Test
    public void moveUp(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,1));
        kid.moveUp();
        kid.move();

        assertEquals(kid.position.y, 2);
    }
    
    @Test
    public void ShouldMoveRight(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,1));
        
        kid.moveTo(new Point (4,1));
        
        assertEquals(kid.position.x, 3);
        assertEquals(kid.position.y, 1);
    }

    @Test
    public void ShouldMoveLeft(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,1));

        kid.moveTo(new Point (0,1));

        assertEquals(kid.position.x, 1);
        assertEquals(kid.position.y, 1);
    }

    @Test
    public void ShouldMoveUp(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,1));

        kid.moveTo(new Point (2,3));

        assertEquals(kid.position.x, 2);
        assertEquals(kid.position.y, 2);
    }

    @Test
    public void ShouldMoveDown(){
        Kid kid = new Kid();

        kid.setPosition(new Point(2,1));

        kid.moveTo(new Point (2,0));

        assertEquals(kid.position.x, 2);
        assertEquals(kid.position.y, 0);
    }
    
    
    
}