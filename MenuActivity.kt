package com.example.cf

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    private val listeBoissons = listOf(
        Boisson("Espresso", "Court et intense", 10, R.drawable.espresso),
        Boisson("Café crème", "Espresso et lait chaud", 12, R.drawable.cafe_creme),
        Boisson("Américano", "Espresso allongé d'eau chaude", 12, R.drawable.americano),
        Boisson("Cappuccino", "Mousse de lait onctueuse", 15, R.drawable.cappuccino),
        Boisson("Latte", "Beaucoup de lait, doux", 15, R.drawable.latte),
        Boisson("Moka", "Café et chocolat", 17, R.drawable.moka),
        Boisson("Thé à la menthe", "Thé vert, menthe fraîche", 8, R.drawable.the_menthe),
        Boisson("Thé vert", "Nature, sans sucre", 9, R.drawable.the_vert),
        Boisson("Chocolat chaud", "Cacao et lait", 14, R.drawable.chocolat_chaud),
        Boisson("Jus d'orange", "Pressé minute", 12, R.drawable.jus_orange),
        Boisson("Smoothie fraise", "Fraise, banane, yaourt", 18, R.drawable.smoothie_fraise),
        Boisson("Eau minérale", "50 cl", 5, R.drawable.eau_minerale)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Log.d("MENU", "nombre de boissons : ${listeBoissons.size}")

        val listView: ListView = findViewById(R.id.listeBoissons)
        listView.adapter = BoissonAdapter(this, listeBoissons)

        listView.setOnItemClickListener { _, _, position, _ ->
            val boisson = listeBoissons[position]
            val intent = Intent(this, PersonnalisationActivity::class.java)
            intent.putExtra("NOM", boisson.nom)
            intent.putExtra("PRIX", boisson.prix)
            intent.putExtra("IMAGE", boisson.image)
            startActivity(intent)
        }
    }
}