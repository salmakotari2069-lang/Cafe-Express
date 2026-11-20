package com.example.cf

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PersonnalisationActivity : AppCompatActivity() {

    private var prixBase = 0

    private lateinit var rgTaille: RadioGroup
    private lateinit var cbLait: CheckBox
    private lateinit var cbCreme: CheckBox
    private lateinit var cbEmporter: CheckBox
    private lateinit var tvPrix: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnalisation)

        val nom = intent.getStringExtra("NOM") ?: ""
        prixBase = intent.getIntExtra("PRIX", 0)
        val image = intent.getIntExtra("IMAGE", 0)

        findViewById<TextView>(R.id.tvNomProduit).text = nom
        findViewById<ImageView>(R.id.imgProduit).setImageResource(image)

        rgTaille = findViewById(R.id.rgTaille)
        cbLait = findViewById(R.id.cbLait)
        cbCreme = findViewById(R.id.cbCreme)
        cbEmporter = findViewById(R.id.cbEmporter)
        tvPrix = findViewById(R.id.tvPrix)

        rgTaille.setOnCheckedChangeListener { _, _ -> calculerPrix() }
        cbLait.setOnCheckedChangeListener { _, _ -> calculerPrix() }
        cbCreme.setOnCheckedChangeListener { _, _ -> calculerPrix() }
        cbEmporter.setOnCheckedChangeListener { _, _ -> calculerPrix() }

        calculerPrix()
    }

    private fun calculerPrix() {
        var total = prixBase
        when (rgTaille.checkedRadioButtonId) {
            R.id.rbPetit -> total -= 2
            R.id.rbGrand -> total += 2
        }
        if (cbLait.isChecked) total += 1
        if (cbCreme.isChecked) total += 2
        if (cbEmporter.isChecked) total += 2

        tvPrix.text = "$total DH"
    }
}