package com.company.characters;

import com.company.Configuration;

import java.util.Random;

/**
 * author @pater
 */
public class Gift extends ObjectOnBoardImpl{

    public Gift() {
        
        setToRandomToyImage();
    }
    
    private void setToRandomToyImage(){

        Random random = new Random();

        switch( random.nextInt(4) ){
            case 0:
                image = Configuration.TOY_1_IMAGE;
                break;
            case 1:
                image = Configuration.TOY_2_IMAGE;
                break;
            case 2:
                image = Configuration.TOY_3_IMAGE;
                break;
            case 3:
                image = Configuration.TOY_4_IMAGE;
                break;
            default:
                image = Configuration.TOY_5_IMAGE;
                break;
        }
    }
}
