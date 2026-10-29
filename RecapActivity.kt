package com.example.cf

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recapactivity)
        val txtclient: TextView = findViewById(R.id.txtclient)
        val txttotalcafe: TextView = findViewById(R.id.txttotalcafe)
        val txttotalthe: TextView = findViewById(R.id.txttotalthe)
        val txttotalcroissant: TextView = findViewById(R.id.txttotalcroissant)
        val txttotalrecap: TextView = findViewById(R.id.txttotalrecap)
        val btnmodifier: Button = findViewById(R.id.btnmodifier)
        val btnconfirmer: Button = findViewById(R.id.btnconfirmer)

        val nom = intent.getStringExtra("NOM_CLIENT")
        val qteCafe = intent.getIntExtra("QTE_CAFE", 0)
        val qteThe = intent.getIntExtra("QTE_THE", 0)
        val qteCroissant = intent.getIntExtra("QTE_CROISSANT", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        txtclient.text = "Client : $nom"
        txttotalcafe.text = "Café : $qteCafe × 10 DH = ${qteCafe * 10} DH"
        txttotalthe.text = "Thé : $qteThe × 8 DH = ${qteThe * 8} DH"
        txttotalcroissant.text = "Croissant : $qteCroissant × 6 DH = ${qteCroissant * 6} DH"
        txttotalrecap.text = "Total : $total DH"

        btnmodifier.setOnClickListener {
            finish()
        }

        btnconfirmer.setOnClickListener {
            Toast.makeText(this, "Commande de $nom envoyée en cuisine", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
