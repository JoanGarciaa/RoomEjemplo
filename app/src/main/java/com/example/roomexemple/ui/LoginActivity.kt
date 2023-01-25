package com.example.roomexemple.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomexemple.R
import com.example.roomexemple.viewmodel.UsuariViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var usuariViewModel: UsuariViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var buttonLogin: Button = findViewById(R.id.buttonEntrar)
        var buttonRegister: Button = findViewById(R.id.buttonRegister)


        lateinit var nombreLogin : String
        lateinit var passwordLogin : String

        usuariViewModel = ViewModelProvider(this).get(UsuariViewModel::class.java)

        buttonLogin.setOnClickListener(){
            nombreLogin = findViewById<EditText>(R.id.editTextNombreLogin).text.toString()
            passwordLogin = findViewById<EditText>(R.id.editTextPasswordLogin).text.toString()

            usuariViewModel.loginClient(this,nombreLogin,passwordLogin)!!.observe(this, Observer {llistaClients ->
                Toast.makeText(this,"Bienvenido: ${llistaClients[0].nombre}" , Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
        }

        buttonRegister.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}