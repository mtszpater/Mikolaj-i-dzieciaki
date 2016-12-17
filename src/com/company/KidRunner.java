package com.company;

/**
 * author @pater
 */
public class KidRunner implements Runnable{

    public KidRunner(Kid kid) {
        this.kid = kid;
    }

    Kid kid = new Kid();
    
    @Override
    public void run() {
        
        kid.moveRandomWay();
        
    }
}
