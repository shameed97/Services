package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    //used to Thread at background....
    final class MyThreadClass implements Runnable {
        int service_id;

        public MyThreadClass(int service_id) {

            this.service_id = service_id;
        }


        @Override
        public void run() {
            int i = 0;
            synchronized (this) {
                while (i < 10) {

                    try {
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(service_id);
            }

        }
    }


    //Used to Create Service
    @Override
    public void onCreate() {
        super.onCreate();
    }

    ////Used to start the service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started..", Toast.LENGTH_LONG).show();
        Thread thread = new Thread(new MyThreadClass(startId));
        thread.start();


        return START_STICKY;
    }

    ////used to Destroy Service
    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service Stopped...", Toast.LENGTH_SHORT).show();
    }

    ///Necessary Method for Bind Service
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
