package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * author @pater
 */
abstract class Char {
    
    protected String image;

    private BufferedImage createImageIcon() {
        try {
            return ImageIO.read(getClass().getResource(image));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public BufferedImage getIcon(){
        BufferedImage icon = createImageIcon();
        return icon;
    }
}
