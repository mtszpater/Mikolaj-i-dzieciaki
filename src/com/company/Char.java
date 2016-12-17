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
    protected int dx;
    protected int dy;

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


    public void move() {
        this.position.setX(this.position.x + dx);
        this.position.setY(this.position.y + dy);
    }
}
