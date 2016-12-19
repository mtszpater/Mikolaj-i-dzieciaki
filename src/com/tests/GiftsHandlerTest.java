package com.tests;

import com.company.Configuration;
import com.company.GiftHandler;
import com.company.Point;
import com.company.characters.Gift;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class GiftsHandlerTest {
    
    @Test
    public void ifIAddGiftIShouldHaveOne(){
        
        Gift gift = new Gift();
        gift.setPosition( new Point(3,4) );
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();
        
        giftHandler.addGiftToList(gift);
        
        assertEquals( giftHandler.getCount(), 1);
    }
    
    @Test
    public void ifIAddGiftsIWantToGetThem(){
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();


        Gift gift = new Gift();
        gift.setPosition( new Point(3,4) );
        
        giftHandler.addGiftToList(gift);
        gift = new Gift();
        gift.setPosition( new Point(4,4) );
        giftHandler.addGiftToList(gift);
        
        
        assertEquals( giftHandler.getGifts().size(), 2);
    }
    
    @Test
    public void ShouldReturnGiftOnThatPosition(){

        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();


        Gift gift = new Gift();
        gift.setPosition( new Point(3,4) );

        
        giftHandler.addGiftToList( gift );


        assertEquals( giftHandler.getGiftOnPosition( new Point( 3,4 )), gift);
    }
    
    @Test
    public void OnlyOneGiftOnPosition(){

        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();


        Gift gift = new Gift();
        gift.setPosition( new Point(3,4) );


        giftHandler.addGiftToList( gift );
        giftHandler.addGiftToList( gift );


        assertEquals( giftHandler.getCount(), 1);
        
    }
    
    @Test
    public void BagShouldBeEmpty(){
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();

        
        for( int i = 0; i <= Configuration.SANTA_BAG_LIMIT; ++i) {
            Gift gift = new Gift();
            gift.setPosition(new Point(3, i));


            giftHandler.addGiftToList(gift);

        }

        assertEquals( giftHandler.getCount(), Configuration.SANTA_BAG_LIMIT);
        
        
        

    }
    
}
