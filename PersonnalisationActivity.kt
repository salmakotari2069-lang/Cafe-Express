package com.example.cf

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class PersonnalisationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personnaliser)

        val rgTaille: RadioGroup = findViewById(R.id.rgTaille)
        val chkSucre: CheckBox = findViewById(R.id.chkSucre)
        val chkCreme: CheckBox = findViewById(R.id.chkcréme)
        val chkCannelle: CheckBox = findViewById(R.id.chkcannelle)
        val swEmporter: SwitchCompat = findViewById(R.id.swEmporter)
        val spnLait: Spinner = findViewById(R.id.spnLait)
        val txtResultat: TextView = findViewById(R.id.txtResultat)
        val btnCalculer: Button = findViewById(R.id.btnCalculer)

        val laits = listOf("Lait entier", "Lait écrémé", "Lait d'amande (+3 DH)", "Sans lait")
        val prixLaits = listOf(0, 0, 3, 0)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, laits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnLait.adapter = adapter

        btnCalculer.setOnClickListener {
            val idTaille = rgTaille.checkedRadioButtonId
            val taille = when (idTaille) {
                R.id.rbPetit -> "Petit"
                R.id.rbMoyen -> "Moyen"
                R.id.rbGrand -> "Grand"
                else -> "aucune"
            }
            val prixTaille = when (idTaille) {
                R.id.rbPetit -> 8
                R.id.rbMoyen -> 10
                R.id.rbGrand -> 12
                else -> 0
            }

            val supplements = mutableListOf<String>()
            var prixSupplements = 0
            if (chkSucre.isChecked) supplements.add("sucre")
            if (chkCreme.isChecked) {
                supplements.add("crème")
                prixSupplements += 2
            }
            if (chkCannelle.isChecked) {
                supplements.add("cannelle")
                prixSupplements += 1
            }

            val emporter = if (swEmporter.isChecked) "à emporter" else "sur place"
            val prixEmporter = if (swEmporter.isChecked) 2 else 0

            val position = spnLait.selectedItemPosition
            val lait = spnLait.selectedItem.toString()
            val prixLait = prixLaits[position]

            val prix = prixTaille + prixSupplements + prixEmporter + prixLait

            val resume = mutableListOf(taille)
            resume.addAll(supplements)
            resume.add(lait)
            resume.add(emporter)

            txtResultat.text = "${resume.joinToString(", ")}\nPrix : $prix DH"
        }
    }
}
