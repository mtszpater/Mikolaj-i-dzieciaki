package com.company.characters;

import javax.swing.*;
import java.util.Random;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;


/**
 * author @pater
 */
class KidRunner {
    private Kid kid;
    
    synchronized void move() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected synchronized Void doInBackground() throws Exception {
                    while (!kid.grounded) {
                        kid.play(currentThread());
                        System.out.println("ZASYIAM " + kid.toString());
                        Random random = new Random();
                        sleep(random.nextInt(5000));
                    }
                return null;
            }
        };

        worker.execute();
    }
    
    KidRunner(Kid kid) {
        this.kid = kid;
    }
}
