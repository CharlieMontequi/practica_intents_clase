 package com.example.practica_intents_clase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

 class MainActivity : AppCompatActivity() {
     // fija la vista a la que referenciar el text view que va a mostar los datos que lleguen
     private lateinit var tv_seleccionado_fijo : TextView

    // es la forma de poder iniciar un activity y que pueda recibir informacion de otro
     private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
     // lo que ese esta haciendo es una landa para poner la funcion registerForActivityResult y hacer su funcionalidad
     { resultado ->
         if(resultado.resultCode == Activity.RESULT_OK){
             // se recogen los datos que vienen el otro activity
             val tomarDatos = resultado.data?.getStringExtra("azul")
             // lleva los datos a la vista fijada
             tv_seleccionado_fijo.text = tomarDatos
         }
     }



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoPrimero = findViewById<EditText>(R.id.ett_primero)
         // se esta fijando la referencia a la vista que mostrara la info al elemento del layoout
         tv_seleccionado_fijo= findViewById<TextView>(R.id.tv_primero)
        val enviar = findViewById<Button>(R.id.bt_enviar_primero)
         val texto = textoPrimero.text

         // esto es lo que va a permitir cambiar la vista de una a otra
         enviar.setOnClickListener{
             // se declara el intent que permite enviar información a otra vista/ activity
         val intencionEnvio = Intent(this, Actividad2::class.java) // aqui se determina a cual se va a ir
            // OJO- no entiendo porque si se quita esto no funciona
             startForResult.launch(intencionEnvio)

         }

    }
}