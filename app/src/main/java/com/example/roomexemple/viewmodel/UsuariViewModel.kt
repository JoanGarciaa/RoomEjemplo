package com.example.roomexemple.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomexemple.model.Client
import com.example.roomexemple.repositori.Repositori
import java.util.SimpleTimeZone
import kotlin.math.log

class UsuariViewModel : ViewModel() {

    var client: LiveData<List<Client>>? = null;


    fun newClient(context: Context, nombre : String, edat : Int, password : String, professio: String){
        var clientVM=Client(nombre,edat,password,professio)
        Repositori.insertClient(context,clientVM)
    }

    fun obtenirClients(context: Context): LiveData<List<Client>>?{
            client = Repositori.getClient(context)
        return client
    }

    fun loginClient(context: Context, nombre: String, passw: String): LiveData<List<Client>>?{
        client = Repositori.loginClient(context,nombre,passw)
        Log.i("$client","$client")
        return client
    }

}