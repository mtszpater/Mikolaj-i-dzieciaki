package com.company;

import javax.swing.*;

/**
 * author @pater
 */
public class KidRunner extends Thread {
    Kid kid;
    
    public KidRunner(Kid kid) {
        this.kid = kid;

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                System.out.println("hehe");
                kid.moveRandomWay();
                return null;
            }
        };

        worker.execute();
    }
    
}
