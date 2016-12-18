package com.company.characters;

import javax.swing.*;
import java.util.Random;


/**
 * author @pater
 */
public class KidRunner {
    Kid kid;
    
    public void move() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                    while (!kid.grounded) {
                        kid.moveRandomWay();
                        System.out.println("Current position : " + kid.position.x + " , " + kid.position.y);
                        // TODO:
//                        kid.play();
//                        System.out.println("ZASYIAM " + kid.toString());
//                        kid.image = Configuration.KID_IMAGE;
                        Random random = new Random();
                        Thread.sleep(random.nextInt(5000));
                    }
                return null;
            }
        };

        worker.execute();
    }
    
    public KidRunner(Kid kid) {
        this.kid = kid;
    }
}
