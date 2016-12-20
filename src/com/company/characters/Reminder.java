package com.company.characters;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author @pater
 */
public class Reminder {
    Timer timer;
    volatile boolean end = false;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public synchronized void run() {
            end = true;
            timer.cancel(); //Terminate the timer thread
        }
    }
}