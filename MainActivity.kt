package com.example.cf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var qteCafe = 0
    var qteThe = 0
    var qteCroissant = 0

    lateinit var btnMoinsCafe: Button
    lateinit var txtQteCafe: TextView
    lateinit var btnPlusCafe: Button

    lateinit var btnMoinsThe: Button
    lateinit var txtQteThe: TextView
    lateinit var btnPlusThe: Button

    lateinit var btnMoinsCroissant: Button
    lateinit var txtQteCroissant: TextView
    lateinit var btnPlusCroissant: Button

    lateinit var edtNom: EditText
    lateinit var txtTotal: TextView
    lateinit var btnVider: Button
    lateinit var btnCommander: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoinsCafe = findViewById(R.id.btnMoinsCafe)
        txtQteCafe = findViewById(R.id.txtQteCafe)
        btnPlusCafe = findViewById(R.id.btnPlusCafe)

        btnMoinsThe = findViewById(R.id.btnMoinsThe)
        txtQteThe = findViewById(R.id.txtQteThe)
        btnPlusThe = findViewById(R.id.btnPlusThe)

        btnMoinsCroissant = findViewById(R.id.btnMoinsCroissant)
        txtQteCroissant = findViewById(R.id.txtQteCroissant)
        btnPlusCroissant = findViewById(R.id.btnPlusCroissant)

        edtNom = findViewById(R.id.edtNom)
        txtTotal = findViewById(R.id.txtTotal)
        btnVider = findViewById(R.id.btnVider)
        btnCommander = findViewById(R.id.btnCommander)

        btnPlusCafe.setOnClickListener {
            qteCafe++
            txtQteCafe.text = qteCafe.toString()
            afficherTotal()
        }
        btnMoinsCafe.setOnClickListener {
            if (qteCafe > 0) qteCafe--
            txtQteCafe.text = qteCafe.toString()
            afficherTotal()
        }

        btnPlusThe.setOnClickListener {
            qteThe++
            txtQteThe.text = qteThe.toString()
            afficherTotal()
        }
        btnMoinsThe.setOnClickListener {
            if (qteThe > 0) qteThe--
            txtQteThe.text = qteThe.toString()
            afficherTotal()
        }

        btnPlusCroissant.setOnClickListener {
            qteCroissant++
            txtQteCroissant.text = qteCroissant.toString()
            afficherTotal()
        }
        btnMoinsCroissant.setOnClickListener {
            if (qteCroissant > 0) qteCroissant--
            txtQteCroissant.text = qteCroissant.toString()
            afficherTotal()
        }

        btnCommander.setOnClickListener {
            val nom = edtNom.text.toString().trim()
            val nbArticles = qteCafe + qteThe + qteCroissant
            if (nom.isEmpty()) {
                edtNom.error = "Nom obligatoire"
                edtNom.requestFocus()
            } else if (nbArticles == 0) {
                Toast.makeText(this, "Le panier est vide", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, RecapActivity::class.java)
                intent.putExtra("NOM_CLIENT", nom)
                intent.putExtra("QTE_CAFE", qteCafe)
                intent.putExtra("QTE_THE", qteThe)
                intent.putExtra("QTE_CROISSANT", qteCroissant)
                intent.putExtra("TOTAL", calculerTotal())
                startActivity(intent)
            }
        }

        btnVider.setOnClickListener {
            qteCafe = 0
            qteThe = 0
            qteCroissant = 0
            txtQteCafe.text = "0"
            txtQteThe.text = "0"
            txtQteCroissant.text = "0"
            edtNom.setText("")
            edtNom.error = null
            afficherTotal()
            Toast.makeText(this, "Commande annulée", Toast.LENGTH_SHORT).show()
        }
    }
    fun calculerTotal(): Int {
        return qteCafe * 10 + qteThe * 8 + qteCroissant * 6
    }

    fun afficherTotal() {
        txtTotal.text = "Total : ${calculerTotal()} DH"
    }
}
