package com.company.characters;

/**
 * author @pater
 */
public abstract class Char extends ObjectOnBoardImpl {
    int dx;
    int dy;

    public void move() {
        this.position.setX(this.position.x + dx);
        this.position.setY(this.position.y + dy);
    }
}
