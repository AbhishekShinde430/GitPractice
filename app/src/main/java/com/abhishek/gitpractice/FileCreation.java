package com.abhishek.gitpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCreation extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_creation);
        mEditText = findViewById(R.id.edit_text);
    }

    public void save(View v) {
        File myDir = new File(getCacheDir(), "folder");
        myDir.mkdir();
        try {
            String rootPath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/MyFolder/";
            File root = new File(rootPath);
            if (!root.exists()) {
                root.mkdirs();
            }
            File f = new File(rootPath + "mttext.txt");
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();

            FileOutputStream out = new FileOutputStream(f);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}