package com.company.characters;


import com.company.gui.SantaHunting;

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
                boolean gameIsActive = SantaHunting.getInstance().isActive();
                while ( ! kid.grounded && gameIsActive ) {
                        kid.play(currentThread());
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
