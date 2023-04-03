package com.example.mytest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zyb.personcenter.PersonCenterView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<PersonCenterView>(R.id.two).setOnClickListener {
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("gym","start 2")
    }

    override fun onResume() {
        super.onResume()
        Log.d("gym","resume 2")
        Thread.sleep(2000)
    }

    override fun onPause() {
        super.onPause()
        Log.d("gym","pause 2")
    }

    override fun onStop() {
        super.onStop()
        Log.d("gym","stop 2")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}