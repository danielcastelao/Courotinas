package com.dam2.courotinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonCuentaAtras: Button = findViewById(R.id.inicio)

        botonCuentaAtras.setOnClickListener{
            // cada vez que le doy al click empieza la cuenta atrás
            cuentaAtras()
        }
    }
    fun cuentaAtras() { // funcion con retardo
        // variable para poder identificar la courutina
        var jobCuentaAtras: Job? = null
        // lanzamos la courutina y guardamos su identificador en jobCuentaAtras
        jobCuentaAtras = GlobalScope.launch(Dispatchers.Main){ // launch Lanza una courutina y continua
            var contandor = 3
            while (contandor >0) {
                Log.d("Courutina", jobCuentaAtras.toString() + ":" + contandor.toString())
                delay(1000L) // non-blocking delay para 1 segundo
                contandor-- // descuenta uno
            }

        }
        Log.d("Courutina","Lanzada:" + " " + jobCuentaAtras.toString()) // esto ocurre a espensas de la courutina
    }
}