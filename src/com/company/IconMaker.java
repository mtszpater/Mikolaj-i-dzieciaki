package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * author @pater
 */
public class IconMaker {
    String image;

    public IconMaker(String image) {
        this.image = image;
    }
    
    public BufferedImage createImageIcon() {
        try {
            return ImageIO.read(getClass().getResource(image));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
