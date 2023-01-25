package com.example.roomexemple.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexemple.model.Client


@Database(
    entities = [Client::class],
    version = 1,
    exportSchema = false
)
abstract class UsuariDatabase : RoomDatabase() {
    abstract fun usuariDao() : UsuariDao

    companion object {

        @Volatile
        private var INSTANCE: UsuariDatabase? = null

        fun getDatabase(context: Context): UsuariDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): UsuariDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                UsuariDatabase::class.java,
                "usuari_database"
            )
                .build()
        }
    }
}