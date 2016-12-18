package com.tests;

import com.company.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class ConflictHandlerTest {
    
    @Test
    public void ShouldNotBeConflictHere(){
        Santa santa = new Santa();
        santa.setPosition(new Point ( 0 , 1 ));

        Kid kid;
        ArrayList<Kid> kids = new ArrayList<>();

        for( int i = 0; i < 5; ++i){
            kid = new Kid();
            Point point = new Point( 1, i );
            kid.setPosition(point);
            kids.add(kid);
        }
        
        assertEquals( ConflictHandler.isConflict( kids, santa ), false );
    }
    
    @Test
    public void ShouldBeConflictHere(){
        Santa santa = new Santa();
        santa.setPosition(new Point ( 0 , 1 ));

        Kid kid;
        ArrayList<Kid> kids = new ArrayList<>();

        for( int i = 0; i < 5; ++i){
            kid = new Kid();
            Point point = new Point( 0, i );
            kid.setPosition(point);
            kids.add(kid);
        }

        assertEquals( ConflictHandler.isConflict( kids, santa ), true );
    } 
    
    
}
