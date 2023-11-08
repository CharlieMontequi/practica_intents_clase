package com.example.practica_intents_clase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class Actividad2 : AppCompatActivity(){
    private lateinit var tv_seleccionado_fijo : TextView

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
        //al ser un nuevo activity hay que definirle la vista correspondiente, en este caso la vista dos
        setContentView(R.layout.actividad2)

        val textoSegundo = findViewById<EditText>(R.id.ett_secundario)
        tv_seleccionado_fijo = findViewById<TextView>(R.id.tv_secundario)
        val enviar = findViewById<Button>(R.id.bt_enviar_secundario)


        enviar.setOnClickListener{
            // se declara el intent que permite enviar información a otra vista/ activity
            val intencionEnvio = Intent(this, MainActivity::class.java) // aqui se determina a cual se va a ir
            // OJO- no entiendo porque si se quita esto no funciona
            startForResult.launch(intencionEnvio)

        }
    }
}