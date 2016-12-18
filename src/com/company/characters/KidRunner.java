package com.company.characters;

import javax.swing.*;

/**
 * author @pater
 */
public class KidRunner {
    Kid kid;
    
    public void move() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                do{
                    kid.moveRandomWay();
                    System.out.println("Current position : "+ kid.position.x + " , " +  kid.position.y );
                    Thread.sleep(2000);
                }while(!kid.grounded);
                
                return null;
            }
        };

        worker.execute();
    }
    
    public KidRunner(Kid kid) {
        this.kid = kid;
    }
}
