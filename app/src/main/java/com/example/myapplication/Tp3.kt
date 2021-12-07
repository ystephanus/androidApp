package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class Tp3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp3)
        val btn = findViewById<Button>(R.id.btnChange)
        val edt = findViewById<EditText>(R.id.edtPersonName)

        btn.setOnClickListener{
            val intent = Intent(this, TP3_2::class.java)
            intent.putExtra("message",edt.text.toString())
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val cstParent = findViewById<ConstraintLayout>(R.id.cst_parent)

        if(resultCode == RESULT_OK){
            Snackbar.make( cstParent,"ok", Snackbar.LENGTH_LONG).show()
        }
    }
}