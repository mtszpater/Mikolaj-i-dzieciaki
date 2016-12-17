package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * author @pater
 */
public abstract class Char {
    
    public String image;
    public Point position;

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

    public void setPosition(Point position) {
        this.position = position;
    }

    public void moveLeft() { 
        this.position.x -= 1;
    };

    public void moveRight(){
        this.position.x += 1;
    }
    
    public void moveUp(){
        this.position.y += 1;
    }
    
    public void moveDown(){
        this.position.y -= 1;
    }
}
