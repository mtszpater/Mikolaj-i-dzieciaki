package com.company.characters;

import com.company.AreaScanner;

import javax.swing.*;
import java.util.Random;

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

                        Santa santa = Santa.getInstance();
                        
                        if(AreaScanner.isObjectNear(kid.position, santa)) {
                            kid.moveTo(santa.position);
                        }
                        else{
                            kid.moveRandomWay();
                        }

                        
                        
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
    
    KidRunner(Kid kid) {
        this.kid = kid;
    }
}
