package com.company.characters;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author @pater
 */
class Reminder {
    private Timer timer;
    volatile boolean end = false;

    Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    private class RemindTask extends TimerTask {
        public synchronized void run() {
            end = true;
            timer.cancel(); 
        }
    }
}