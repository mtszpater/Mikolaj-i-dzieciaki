package com.company.gui;

import com.company.Configuration;
import com.company.GiftHandler;
import com.company.IconMaker;
import com.company.KidsHandler;
import com.company.characters.Gift;
import com.company.characters.Kid;
import com.company.characters.Santa;

import java.awt.*;

/**
 * author @pater
 */
class Drawer {
    private Graphics g;

    Drawer(Graphics g) {
        this.g = g;
    }

    void drawGifts() {
        GiftHandler giftHandler = GiftHandler.getInstance();
        Gift gift;

        for( int i = 0; i < giftHandler.getCount(); ++i){
            gift = giftHandler.getGiftByIndex(i);
            if(gift.active) {
                g.drawImage(gift.getIcon(), gift.position.x * Configuration.WIDTH_SCALE, gift.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE, null);
            }
        }
    }

    void drawKids(){
        KidsHandler kidsHandler = KidsHandler.getInstance();
        Kid kid;
        
        for(int i = 0; i < Configuration.NUMBER_OF_CHILDREN; ++i){
            kid = kidsHandler.getKidByIndex(i);

            if( kid.grounded )
                g.drawImage(kid.getIcon(), kid.position.x * Configuration.WIDTH_SCALE, kid.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE ,null);
            else
                g.drawImage(kid.getIcon(), kid.position.x * Configuration.WIDTH_SCALE, kid.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE ,null);

        }
    }
    
    void drawSanta() {
        Santa santa = Santa.getInstance();
        g.drawImage(santa.getIcon(),santa.position.x * Configuration.WIDTH_SCALE, santa.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE,  null);
    }

    void drawBackground() {
        g.drawImage(new IconMaker(Configuration.BACKGROUND).createImageIcon(), 0,0, Configuration.WIDTH, Configuration.HEIGHT ,null);
    }
    
}
