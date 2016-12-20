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
    
    void updateStatus() {
        if( kidTouchSanta() || areAllKidsGrounded())
        {
            active = false;
        }
    }

    private boolean areAllKidsGrounded() {
        KidsHandler kids = KidsHandler.getInstance();
        return kids.getCountOfGroundedKids() == kids.getKids().size();
    }

    private boolean kidTouchSanta() {
        KidsHandler kids = KidsHandler.getInstance();
        Santa santa = Santa.getInstance();
        return AreaScanner.isConflict( kids.getKids(), santa );
    }

    void showResult() {
        KidsHandler kids = KidsHandler.getInstance();
        GiftHandler giftHandler = GiftHandler.getInstance();

        int gifts = Configuration.SANTA_BAG_LIMIT - giftHandler.getActiveGiftsCount();

        int reply = JOptionPane.showConfirmDialog(null, 
                "Obdarowanych dzieciaków: "+ kids.getCountOfGroundedKids() + " z " + kids.getKids().size() + "\n"+
                "Pozostałych prezentów: " + gifts + "\n" +
                
                "Autor gry: Mateusz Pater [mtszpater@gmail.com]"
                
                , "Koniec gry", JOptionPane.CLOSED_OPTION);
        if (reply == JOptionPane.CLOSED_OPTION)
        {
            return;
        }
        
    }

    public boolean isActive() {
        return active;
    }
}
