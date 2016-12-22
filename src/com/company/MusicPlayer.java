package com.company;

import javazoom.jl.player.Player;

import java.io.FileInputStream;

/**
 * author @pater
 */
class MusicPlayer {
    void playBackground() {
        try{

            FileInputStream fis = new FileInputStream("src/com/company/music.wav");
            Player playMP3 = new Player(fis);

            playMP3.play();

        }
        catch(Exception e){System.out.println(e);}
    }
    
    
}
