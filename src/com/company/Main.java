package com.company;

import com.company.gui.SantaHunting;

public class Main {

    public static void main(String[] args) {
        
        SantaHunting.getInstance();


        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playBackground();
        
    }
}
