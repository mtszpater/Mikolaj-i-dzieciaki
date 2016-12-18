package com.tests;

import com.company.ConflictHandler;
import com.company.Point;
import com.company.characters.*;
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

        Char kid;
        ArrayList<Char> kids = new ArrayList<>();

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
        ArrayList<Char> kids = new ArrayList<>();

        for( int i = 0; i < 5; ++i){
            kid = new Kid();
            Point point = new Point( 0, i );
            kid.setPosition(point);
            kids.add(kid);
        }

        assertEquals( ConflictHandler.isConflict( kids, santa ), true );
    }
    
    @Test
    public void CheckWhenItIsTheSameObject(){
        ArrayList<Char> kids = new ArrayList<>();
        
        Santa santa = new Santa();
        santa.setPosition(new Point(0,1));
        kids.add(santa);
        
        assertEquals( ConflictHandler.isConflict(kids, santa), false);
    }
    
    @Test
    public void ShouldBeGroundedRight(){
        ArrayList<Kid> kids = new ArrayList<>();

        Santa santa = new Santa();
        santa.setPosition(new Point(0,1));
        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( ConflictHandler.getKidFromNeighborhood(kids, santa), kid);
        
    }

    @Test
    public void ShouldBeGroundedLeft(){
        ArrayList<Kid> kids = new ArrayList<>();

        Santa santa = new Santa();
        santa.setPosition(new Point(2,1));
        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( ConflictHandler.getKidFromNeighborhood(kids, santa), kid);

    }

    @Test
    public void ShouldBeGroundedUp(){
        ArrayList<Kid> kids = new ArrayList<>();

        Santa santa = new Santa();
        santa.setPosition(new Point(0,1));
        Kid kid = new Kid();
        kid.setPosition(new Point(0,2));
        kids.add(kid);

        assertEquals( ConflictHandler.getKidFromNeighborhood(kids, santa), kid);

    }

    @Test
    public void ShouldBeGroundedDown(){
        ArrayList<Kid> kids = new ArrayList<>();

        Santa santa = new Santa();
        santa.setPosition(new Point(0,2));
        Kid kid = new Kid();
        kid.setPosition(new Point(0,1));
        kids.add(kid);

        assertEquals( ConflictHandler.getKidFromNeighborhood(kids, santa), kid);

    }

//    @Test
//    public void ShouldReturnNullWithConflict(){
//        ArrayList<Kid> kids = new ArrayList<>();
//
//        Santa santa = new Santa();
//        santa.setPosition(new Point(0,1));
//        Kid kid = new Kid();
//        kid.setPosition(new Point(1,1));
//        kids.add(kid);
//
//        assertEquals( ConflictHandler.getKidWithConflictFromList(kids, santa), null);
//
//    }
}
