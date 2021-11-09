package com.abhishek.gitpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class kotlinActivity : AppCompatActivity() {

    val testVariable:String? =null
    val sbc="";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        Thread.setDefaultUncaughtExceptionHandler(handleAppCrash)

        Log.d("TAG", "onCreate: ${testVariable!!.length}")

        /*val it = Intent(this@kotlinActivity, FileCreation::class.java)
        startActivity(it)*/



    }


    private val handleAppCrash = Thread.UncaughtExceptionHandler { thread, ex ->
        try {
            Log.d("Error",ex.toString())
            Log.e("Error",Log.getStackTraceString(ex))



        } catch (e: Exception) {
            e.message
        }
    }

}