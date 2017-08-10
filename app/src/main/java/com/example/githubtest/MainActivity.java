package com.example.githubtest;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private Handler mHandler;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();

        mHandler.post(() -> Log.d(TAG, "Hello"));

        mHandler.post(()-> Log.d(TAG,"Hello"));

        Runnable run = ()-> Log.d(TAG,"Hello");

        MyInterface my = (a,b)->{
            Log.d(TAG,"Hello"+a);
            return a+b;
        };

        MyInterface my2 = (a, b) -> a+b;

        Thread th = new Thread(run);
        th.start();

        Consumer<String> consumer = t->Log.d(TAG,t);
        consumer.accept("Hello word");


        BiConsumer<String, String> biConsumer = (t,u)->Log.d(TAG, t+", "+u);
        biConsumer.accept("hello", "world");

    }

    interface MyInterface {
        int method(int a, int b);
    }

}
