package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class Tp3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp3)
        val btn = findViewById(R.id.btnChange) as Button;
        val edt = findViewById(R.id.edtPersonName) as EditText;

        btn.setOnClickListener{
            val intent = Intent(this, TP3_2::class.java);
            intent.putExtra("message",edt.text.toString());
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val cst_parent = findViewById<ConstraintLayout>(R.id.cst_parent);

        if(resultCode == RESULT_OK){
            Snackbar.make( cst_parent,"ok", Snackbar.LENGTH_LONG).show()
        }
    }
}