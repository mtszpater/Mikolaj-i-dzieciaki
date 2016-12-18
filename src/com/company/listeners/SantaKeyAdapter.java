package com.company.listeners;

import com.company.characters.Santa;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * author @pater
 */
public class SantaKeyAdapter extends KeyAdapter {

    private final Santa santa;

    public SantaKeyAdapter(Santa santa) {
        this.santa = santa;
    }

    @Override
    public void keyReleased(KeyEvent e) {
            santa.keyReleased(e);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
            santa.keyPressed(e);
    }
    
}
