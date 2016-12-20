package com.tests;

import com.company.AreaScanner;
import com.company.GiftHandler;
import com.company.Point;
import com.company.characters.*;
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
    public void ShouldBeGroundedRight(){
        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();
        
        Gift gift = new Gift();
        gift.setPosition( new Point( 0,1 ));
        giftHandler.addGiftToList(gift);
        
        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(0,1))), kid);
        
    }

    @Test
    public void ShouldBeGroundedLeft(){

        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 2,1 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(2,1))), kid);

    }

    @Test
    public void ShouldBeGroundedUp(){

        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 0,1 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(0,2));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(0,1))), kid);

    }

    @Test
    public void ShouldBeGroundedDown(){
        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 0,2 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(0,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(0,2))), kid);

    }


    @Test
    public void ShouldBeGroundedLeftTop(){
        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 0,2 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(0,2))), kid);

    }

    @Test
    public void ShouldBeGroundedRightTop(){
        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 2,2 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(2,2))), kid);

    }

    @Test
    public void ShouldBeGroundedLeftDown(){
        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 0,0 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(0,0))), kid);

    }

    @Test
    public void ShouldBeGroundedRightDown(){
        ArrayList<Kid> kids = new ArrayList<>();
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        Gift gift = new Gift();
        gift.setPosition( new Point( 2,0 ));
        giftHandler.addGiftToList(gift);

        Kid kid = new Kid();
        kid.setPosition(new Point(1,1));
        kids.add(kid);

        assertEquals( AreaScanner.getKidFromNeighborhood(kids, giftHandler.getGiftOnPosition(new Point(2,0))), kid);

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
