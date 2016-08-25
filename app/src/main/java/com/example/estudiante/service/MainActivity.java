package com.example.estudiante.service;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FallQueue fallthread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fallthread = new FallQueue();
        fallthread.start();
        gameStart();
    }

    public void gameStart(){

        fallthread.handler.post(new Runnable() {
            @Override
            public void run() {

                Button button1 = (Button) findViewById(R.id.button);

                float bottomOfScreen = getResources().getDisplayMetrics()
                        .heightPixels - (button1.getHeight() * 4);
                button1.setVisibility(View.VISIBLE);
                button1.animate().translationY(bottomOfScreen).setInterpolator(new AccelerateInterpolator())
                        .setInterpolator(new BounceInterpolator())
                        .setDuration(10000);

            }
        });




        fallthread.handler.post(new Runnable() {
            @Override
            public void run() {

                Button button2 = (Button) findViewById(R.id.button2);

                float bottomOfScreen = getResources().getDisplayMetrics()
                        .heightPixels - (button2.getHeight() * 4);
                button2.setVisibility(View.VISIBLE);
                button2.animate().translationY(bottomOfScreen).setInterpolator(new AccelerateInterpolator())
                        .setInterpolator(new BounceInterpolator())
                        .setDuration(10000);

            }
        });


    }
    // Method to start the service
    public void startService(View view) {
        startService(new Intent(getBaseContext(), SimpleService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), SimpleService.class));
    }
}
