package com.abhishek.gitpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Debug.startMethodTracing("sample");
      //  Thread.setDefaultUncaughtExceptionHandler(handleAppCrash);
        Thread.setDefaultUncaughtExceptionHandler(handleAppCrash);
       // Toast.makeText(MainActivity.this,"hhihji",Toast.LENGTH_LONG).show();
        /*String abc = null;
        Log.d("TAG", "onCreate: "+abc.trim());


*/

        Intent it=new Intent(MainActivity.this,kotlinActivity.class);
        startActivity(it);




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    private final Thread.UncaughtExceptionHandler handleAppCrash =
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(@NotNull Thread thread, Throwable ex) {
                    try {
                        Log.e("error", ex.toString());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
                        Date now = new Date();
                        String fileName = formatter.format(now) + ".txt";//like 2016_01_12.txt


                    }catch (Exception e){
                        e.getMessage();
                    }


                    //send email here
                }
            };


    public class LastChanceHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            Log.e("error", e.toString());
            Intent intent = new Intent (Intent.ACTION_SEND);
            intent.setType ("plain/text");
            intent.putExtra (Intent.EXTRA_EMAIL, new String[] {"me@mydomain.com"});
            intent.putExtra (Intent.EXTRA_SUBJECT, "log file");
            startActivityForResult (intent, 1);


            // do something here - log to file and upload to    server/close resources/delete files...
        }
    }



}