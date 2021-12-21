package com.example.myapplication

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class IntentImplicite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val edtSite = findViewById<EditText>(R.id.edtSite)
        val btnRechercheSite = findViewById<Button>(R.id.btnRechercheSite)
        val btnRechercheGeo = findViewById<Button>(R.id.btnGeo)
        val edtGeo = findViewById<EditText>(R.id.edtGeo)

        btnRechercheSite.setOnClickListener{

            val site = edtSite.text.toString()
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, site)
            Log.d("intent implicite", "res :"+intent.resolveActivity(packageManager))
            if (!packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty()) {
                startActivity(intent)
            }
            Toast.makeText(this, site, Toast.LENGTH_LONG).show()
        }

        btnRechercheGeo.setOnClickListener {
            val geo = edtGeo.text.toString()
            val url = Uri.parse("geo:0,0?q="+Uri.encode(geo))
            val intent = Intent(Intent.ACTION_VIEW, url)
            startActivity(intent)
        }

    }
}