package com.example.android.stresscpu;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    int num1 = 1, primes1 = 0;
    int num2 = 1, primes2 = 0;
    int num3 = 1, primes3 = 0;
    int num4 = 1, primes4 = 0;
    int num5 = 1, primes5 = 0;

//    int limit = 1000000000;
    int limit = 2147483647;

    /** Called when the Activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(num1 = 1; num1 < limit; num1 ++){
                    int i = 2;
                    while(i <= num1){
                        if(num1 % i == 0)
                            break;
                        i++;
                    }
                    if(i == num1)
                        primes1++;
                }
            }
        });

        final Thread tr2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(num2 = 1; num2 < limit; num2 ++){
                    int i = 2;
                    while(i <= num2){
                        if(num2 % i == 0)
                            break;
                        i++;
                    }
                    if(i == num2)
                        primes2++;
                }

            }
        });
        final Thread tr3 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(num3 = 1; num3 < limit; num3 ++){
                    int i = 2;
                    while(i <= num3){
                        if(num3 % i == 0)
                            break;
                        i++;
                    }
                    if(i == num3)
                        primes3++;
                }
            }
        });
        final Thread tr4 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(num4 = 1; num4 < limit; num4 ++){
                    int i = 2;
                    while(i <= num4){
                        if(num4 % i == 0)
                            break;
                        i++;
                    }
                    if(i == num4)
                        primes4++;
                }
            }
        });

        final Thread tr5 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(num5 = 1; num5 < limit; num5 ++){
                    int i = 2;
                    while(i <= num5){
                        if(num5 % i == 0)
                            break;
                        i++;
                    }
                    if(i == num5)
                        primes5++;
                }
            }
        });

        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
        tr5.start();
    }
}
