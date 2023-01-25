package com.example.roomexemple.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomexemple.R
import com.example.roomexemple.viewmodel.UsuariViewModel
import kotlin.properties.Delegates

class RegisterActivity : AppCompatActivity() {
    lateinit var nombre: String
    var edat by Delegates.notNull<Int>()
    lateinit var password: String
    lateinit var profession: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        lateinit var usuariViewModel: UsuariViewModel
        lateinit var context: Context
        context = this@RegisterActivity
        val buttonRegister = findViewById<Button>(R.id.buttonRegistrarse)

        usuariViewModel = ViewModelProvider(this).get(UsuariViewModel::class.java)

        buttonRegister.setOnClickListener(){
            nombre = findViewById<EditText>(R.id.editTextNombre).text.toString()
            edat = findViewById<EditText>(R.id.editTextEdat).text.toString().toInt()
            password = findViewById<EditText>(R.id.editTextPassword).text.toString()
            profession = findViewById<EditText>(R.id.editTextProfession).text.toString()
            usuariViewModel.newClient(context,nombre,edat, password,profession)
            Toast.makeText(context,"Client creat correctament", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}