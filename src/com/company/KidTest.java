package com.company;

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

}