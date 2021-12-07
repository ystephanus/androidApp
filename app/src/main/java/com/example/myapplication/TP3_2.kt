package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TP3_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp32)

        val txt = findViewById<TextView>(R.id.textView4)
        val btn = findViewById<Button>(R.id.button)
        val bundle = intent.extras
        val text = bundle?.get("message").toString()

        txt.text = text

        btn.setOnClickListener{
            val resultIntent = Intent()
            setResult(RESULT_OK, resultIntent)
            finish()
        }


    }
}