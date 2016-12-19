package com.company.characters;

import com.company.Point;

import java.awt.image.BufferedImage;

/**
 * author @pater
 */
public interface ObjectsOnBoard {
    BufferedImage getIcon();

    void setPosition(Point position);
}
