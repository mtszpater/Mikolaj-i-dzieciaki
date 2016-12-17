package com.tests;

import com.company.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class KidTest {
    
    @Test
    public void ShouldReturnPathToImage(){
        Kid kid = new Kid();
        assertEquals(kid.image, "../../images/kid.png");
    }
    
    @Test
    public void GetCurrentPosition(){
        Kid kid = new Kid();
        kid.setPosition(new Point( 0,0 ));
        
        assertEquals(kid.position.x, 0);
        assertEquals(kid.position.y, 0);
        
    }

}