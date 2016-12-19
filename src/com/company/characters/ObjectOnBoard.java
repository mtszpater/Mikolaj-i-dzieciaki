package com.company.characters;

import com.company.Point;

import java.awt.image.BufferedImage;

/**
 * author @pater
 */
interface ObjectOnBoard {
    BufferedImage getIcon();

    void setPosition(Point position);
}
