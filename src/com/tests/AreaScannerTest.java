package com.tests;

import com.company.AreaScanner;
import com.company.Point;
import com.company.characters.Kid;
import com.company.characters.Santa;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class AreaScannerTest {
    
    @Test
    public void ShouldNotBeConflictHere(){
        Santa santa = Santa.getInstance();
        santa.setPosition(new Point ( 0 , 1 ));

        Kid kid;
        ArrayList<Kid> kids = new ArrayList<>();

        for( int i = 0; i < 5; ++i){
            kid = new Kid();
            Point point = new Point( 1, i );
            kid.setPosition(point);
            kids.add(kid);
        }
        
        assertEquals( AreaScanner.isConflict( kids, santa ), false );
    }
    
    @Test
    public void ShouldBeConflictHere(){
        Santa santa = Santa.getInstance();
        santa.setPosition(new Point ( 0 , 1 ));

        Kid kid;
        ArrayList<Kid> kids = new ArrayList<>();

        for( int i = 0; i < 5; ++i){
            kid = new Kid();
            Point point = new Point( 0, i );
            kid.setPosition(point);
            kids.add(kid);
        }

        assertEquals( AreaScanner.isConflict( kids, santa ), true );
    }
    
    @Test
    public void CheckWhenItIsTheSameObject(){
        ArrayList<Kid> kids = new ArrayList<>();
        
        Kid kid = new Kid();
        kid.setPosition(new Point(0,1));
        kids.add(kid);
        
        assertEquals( AreaScanner.isConflict(kids, kid), false);
    }
    
    
    @Test
    public void ShouldReturnTrueBecauseObjectIsNear(){

        Santa santa = Santa.getInstance();
        santa.setPosition(new Point(0,4));
        
        assertEquals(AreaScanner.isObjectNear(new Point(3,4), santa), true);
        
    }

    @Test
    public void ShouldReturnFalseBecauseObjectIsNotNear(){

        Santa santa = Santa.getInstance();
        santa.setPosition(new Point(8,4));

        assertEquals(AreaScanner.isObjectNear(new Point(3,4), santa), false);

    }
    
}
