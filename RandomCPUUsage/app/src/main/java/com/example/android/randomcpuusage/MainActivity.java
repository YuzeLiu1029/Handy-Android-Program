package com.example.android.randomcpuusage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;


public class MainActivity extends Activity {


    /**
     * Called when the Activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        for(int i = 0; i < 30; i ++){
            MyThread thread = new MyThread();
            Log.i("Loop" ,String.valueOf(i));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e){
                Log.e("Join","Error");
            }
        }

    }


    class MyThread extends Thread{
        Random r = new Random();
        //int max = 2147483647;
        int max = 100000;
        int limit = r.nextInt(max - 10) + 10;
        int num1 = 1, primes1 = 0;

        @Override
        public void run(){
            Log.i("limit", String.valueOf(limit));
            for (num1 = 1; num1 < limit; num1++) {
                int i = 2;
                while (i <= num1) {
                    if (num1 % i == 0)
                        break;
                    i++;
                }
                if (i == num1)
                    primes1++;
            }
        }
    }
}


