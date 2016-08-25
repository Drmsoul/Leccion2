package com.example.estudiante.service;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by estudiante on 25/08/16.
 */
public class FallQueue extends Thread{
    Handler handler;
    public FallQueue() {}



    public void run(){

        Looper.prepare();
        handler = new Handler();
        Looper.loop();

    }

}