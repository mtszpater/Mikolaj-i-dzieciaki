package com.company.characters;

import com.company.IconMaker;
import com.company.Point;

import java.awt.image.BufferedImage;

/**
 * author @pater
 */
abstract class ObjectOnBoardImpl implements ObjectOnBoard {
    public String image;
    public Point position;
    
    @Override
    public BufferedImage getIcon() {
        return new IconMaker(image).createImageIcon();
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }
}
