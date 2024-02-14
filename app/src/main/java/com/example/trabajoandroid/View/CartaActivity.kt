package com.example.trabajoandroid.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.trabajoandroid.R

/**
 * Esta clase representa la actividad de la carta
 * Permite al usuario poder manejarse entre distintas patallas, sirve como un menu
 */
class CartaActivity : AppCompatActivity() {
    // Variables que nos índica los botones de la pantalla
    private lateinit var botonFuncionLista1: CardView
    private lateinit var botonFuncionLista2: CardView
    private lateinit var botonFuncionLista3: CardView
    private lateinit var botonFuncionLista4: CardView
    private lateinit var botonFuncionLista5: CardView
    private lateinit var botonFuncionLista6: CardView
    private lateinit var botonFuncionVolverMenu: CardView
    /**
     * Método que instancia la actividad
     * Establece los escuchas y los métodos que se van a usar
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carta)
        // Se establece los distintos id de la activity
        establecerVariablesID()
        // Se establece las escuchas de la activity
        establecerEscucha()
    }

    /**
     * Método que nos instancia las variables que necesidad recibir un id.
     * Asigna a cada variable su id correspondiente.
     */
    private fun establecerVariablesID() {
        botonFuncionLista1 = findViewById(R.id.cardMenuFuncionLista)
        botonFuncionLista2 = findViewById(R.id.cardMenuFuncionLista2)
        botonFuncionLista3 = findViewById(R.id.cardMenuFuncionLista3)
        botonFuncionLista4 = findViewById(R.id.cardMenuFuncionLista4)
        botonFuncionLista5 = findViewById(R.id.cardMenuFuncionLista5)
        botonFuncionLista6 = findViewById(R.id.cardMenuFuncionLista6)
        botonFuncionVolverMenu= findViewById(R.id.cardMenuGoMenu)
    }
    /**
     * Método que establece los escuchas de las actividades
     * Cuando es pulsado el boton de la actividad tendra un comportamiento .
     */
    private fun establecerEscucha() {
        botonFuncionLista1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        botonFuncionLista2.setOnClickListener {
            startActivity(Intent(this, FuncionLista2Activity::class.java))
        }
        botonFuncionLista3.setOnClickListener {
            startActivity(Intent(this, FuncionLista3Activity::class.java))
        }
        botonFuncionLista4.setOnClickListener {
            startActivity(Intent(this, FuncionLista4Activity::class.java))
        }
        botonFuncionLista5.setOnClickListener {
            startActivity(Intent(this, FuncionLIsta5Activity::class.java))
        }
        botonFuncionLista6.setOnClickListener {
            startActivity(Intent(this, FuncionLista6Activity::class.java))
        }
        botonFuncionVolverMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}