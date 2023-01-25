package com.example.roomexemple.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "client")
data class Client (
    @ColumnInfo(name = "name")
    var nombre : String,
    @ColumnInfo(name = "age")
    var edad : Int,
    @ColumnInfo(name = "passw")
    var password : String,
    @ColumnInfo(name = "job")
    var profession : String
    ){
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}

