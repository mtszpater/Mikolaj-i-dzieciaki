package com.company.characters;

import com.company.Configuration;
import com.company.GiftHandler;
import com.company.Point;

import java.awt.event.KeyEvent;

/**
 * author @pater
 */

public class Santa extends Char {
    private static Santa ourInstance = new Santa();
    public static Santa getInstance() {
        return ourInstance;
    }
    
    private Santa() {
        this.image = Configuration.SANTA_IMAGE;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }

        if(key == KeyEvent.VK_SPACE) {
            putGift();
        }
    }

    private void putGift() {
        Gift gift = new Gift();
        gift.setPosition(new Point( this.position.x, this.position.y ));
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.addGiftToList(gift);
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        
    }
}