package com.company.characters;

/**
 * author @pater
 */
public abstract class Char extends ObjectOnBoardImpl {
    
    protected int dx;
    protected int dy;

    public void move() {
        this.position.setX(this.position.x + dx);
        this.position.setY(this.position.y + dy);
    }
    
}
