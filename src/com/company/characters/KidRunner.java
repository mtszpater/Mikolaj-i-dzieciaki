package com.company.characters;

import javax.swing.*;
import java.util.Random;

import static java.lang.Thread.sleep;


/**
 * author @pater
 */
public class KidRunner {
    Kid kid;
    
    public synchronized void move() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected synchronized Void doInBackground() throws Exception {
                    while (!kid.grounded) {
                        kid.moveRandomWay();
                        // TODO:
//                        kid.play();
//                        System.out.println("ZASYIAM " + kid.toString());
//                        kid.image = Configuration.KID_IMAGE;
                        Random random = new Random();
                        sleep(random.nextInt(1000));
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
