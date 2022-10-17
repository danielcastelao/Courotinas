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

        // boton para lanzar la courutina
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
        // este identificador nos servira para cancelarla
        // Solo podemos cancelar la ultima lanzada
        // TODO: guardar el identificador para varias courutinas y asi poder cancelarlas independientemente
        jobCuentaAtras = GlobalScope.launch(Dispatchers.Main){ // launch Lanza una courutina y continua
            var contandor = 5
            while (contandor >0) {
                Log.d("Courutina", jobCuentaAtras.toString() + ":" + contandor.toString())
                delay(1000L) // non-blocking delay para 1 segundo
                contandor-- // descuenta uno
            }
        }

        // boton para cancelar las courutinas
        val botonCancelar: Button = findViewById(R.id.cancel)
        // el listener lo definimos cada vez que lanzamos una courutina
        botonCancelar.setOnClickListener {
            // cancelamos la courutina
            jobCuentaAtras.cancel()
            Log.d("Courutina", "Cancelando " + jobCuentaAtras.toString())
        }

        Log.d("Courutina","Lanzada:" + " " + jobCuentaAtras.toString()) // esto ocurre a espensas de la courutina
    }


}