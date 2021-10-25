package com.abhishek.gitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList arrayList=new ArrayList();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it=new Intent(MainActivity.this, ExoPlayerActivity.class);
        it.putParcelableArrayListExtra("nana", arrayList);
        startActivity(it);

    }
}