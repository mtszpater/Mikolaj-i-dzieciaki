package com.company.gui;

import com.company.AreaScanner;
import com.company.Configuration;
import com.company.GiftHandler;
import com.company.KidsHandler;
import com.company.characters.Santa;

import javax.swing.*;

/**
 * author @pater
 */
public class SantaHunting extends JFrame{
    private static SantaHunting ourInstance = new SantaHunting();
    private boolean active;
    
    public static SantaHunting getInstance() {
        return ourInstance;
    }

    private SantaHunting() {
        super(Configuration.GAME_TITLE);
        JPanel panel = new MyPanel();
        setResizable(false);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        active = true;
        
    }
    
    public void updateStatus() {
        
        KidsHandler kids = KidsHandler.getInstance();
        Santa santa = Santa.getInstance();
        
        
        if( AreaScanner.isConflict( kids.getKids(), santa ) || kids.getCountOfGroundedKids() == kids.getKids().size() )
        {
            active = false;
        }
        
        
    }

    public boolean isActive() {
        return active;
    }

    public void showResult() {
        KidsHandler kids = KidsHandler.getInstance();

        int reply = JOptionPane.showConfirmDialog(null, "Obdarowanych dzieciaków: "+ kids.getCountOfGroundedKids() + " z " + kids.getKids().size(), "Koniec gry", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            GiftHandler.getInstance().clear();
            KidsHandler.getInstance().clear();
            Santa.getInstance().clear();
            ourInstance = new SantaHunting();
        }
        
    }
}
