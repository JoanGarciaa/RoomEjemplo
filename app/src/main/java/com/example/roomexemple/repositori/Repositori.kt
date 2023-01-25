package com.example.roomexemple.repositori

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.roomexemple.databases.UsuariDatabase
import com.example.roomexemple.model.Client
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {

    companion object{
        var usuariDatabase : UsuariDatabase? = null;

        var client: LiveData<List<Client>>? = null;

        fun initializeDB(context: Context): UsuariDatabase {
            return UsuariDatabase.getDatabase(context)
        }

        fun insertClient(context: Context,client: Client){
            usuariDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                usuariDatabase!!.usuariDao().addClient(client)
            }
        }

        fun getClient(context: Context): LiveData<List<Client>>? {
            usuariDatabase = initializeDB(context)
            client = usuariDatabase!!.usuariDao().getClients()
            return client;
        }

        fun loginClient(context: Context, nombre:String, passw: String): LiveData<List<Client>>?{
            usuariDatabase = initializeDB(context)
            client = usuariDatabase!!.usuariDao().getClientLogin(nombre,passw)
            return client
        }
    }
}