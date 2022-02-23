package cl.example.bitcoinwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import cl.example.bitcoinwallet.ui.AddressGeneratorFragment

/*
[X] Modelo (data class)
[X] Consumo API (retrofit)
[X] Repositorio
[X] ViewModel
[X] ViewBinding
[X] Fragmento de listado (listing)
[X] RecyclerView + Adapter + ViewHolder
[X] Fragmento de detalle (detail)
[X] Persistencia de datos locales (ROOM)
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.main_container, MenuFragment()).commit()
    }
}