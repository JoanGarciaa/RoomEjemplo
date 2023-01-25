package com.example.roomexemple.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexemple.model.Client

@Dao
interface UsuariDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addClient(client: Client)

    @Query("SELECT * FROM client")
    fun getClients(): LiveData<List<Client>>

    @Query("SELECT * FROM client WHERE name =:nombre AND passw=:passw")
    fun getClientLogin(nombre:String, passw: String): LiveData<List<Client>>

}