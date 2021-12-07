package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDec = findViewById<Button>(R.id.btnDec);
        val btnInc = findViewById<Button>(R.id.btnInc);
        val txtRes = findViewById<TextView>(R.id.txtInc);
        val parent = findViewById<ConstraintLayout>(R.id.cst_parent);

        val txtCount = if (savedInstanceState?.get("count") == null )  0 else savedInstanceState.get("count")
        txtRes.text = "$txtCount"
        btnInc.setOnClickListener {
            var incValue = txtRes.text.toString().toInt()
            incValue ++
            txtRes.text = incValue.toString();

            val t = Snackbar.make(parent, "Incrementation", Snackbar.LENGTH_LONG);
            t.show();
        }

        btnDec.setOnClickListener{
            var value = txtRes.text.toString().toInt()
            value --;
            txtRes.setText(value.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val txtRes = findViewById<TextView>(R.id.txtInc);
        outState.putString("count", txtRes.text.toString());
    }

}