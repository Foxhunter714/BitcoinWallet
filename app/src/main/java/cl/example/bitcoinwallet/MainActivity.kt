package cl.example.bitcoinwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import cl.example.bitcoinwallet.ui.AddressGeneratorFragment

/*
[] Modelo (data class)
[X] Consumo API (retrofit)
[] Repositorio
[] ViewModel
[] ViewBinding
[] Fragmento de listado (listing)
[] RecyclerView + Adapter + ViewHolder
[] Fragmento de detalle (detail)
[] Testing unitario para mappers
[] Intent implícito para compartir
[] Persistencia de datos locales (ROOM)
[] Testing para la base de datos*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.main_container, AddressGeneratorFragment()).commit()
    }
}