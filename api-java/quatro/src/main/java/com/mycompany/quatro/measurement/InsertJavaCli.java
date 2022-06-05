package com.mycompany.quatro.measurement;

import java.util.Timer;
import java.util.TimerTask;

public class InsertJavaCli {
    public static void main(String[] args) {
        Measurement measurement = new Measurement();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                measurement.run();
            }
        }, 0, 60000);
    }
}
