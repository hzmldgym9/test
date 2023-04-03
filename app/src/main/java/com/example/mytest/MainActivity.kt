package com.example.mytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.hello).setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("gym","start 1")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("gym","onRestart 1")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("gym","onNewIntent 1")
    }

    override fun onResume() {
        super.onResume()
        Log.d("gym","resume 1")
    }

    override fun onPause() {
        super.onPause()
        Log.d("gym","pause 1")
    }

    override fun onStop() {
        super.onStop()
        Log.d("gym","stop 1")
    }

}