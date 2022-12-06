package com.dispositivosmoviles.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dispositivosmoviles.model.Lugar

@Database(entities=[Lugar::class], version = 1, exportSchema = false)
abstract class LugarDatabaseComida : RoomDatabase(){
    abstract fun lugarDao() : LugarComida

    companion object {
        @Volatile
        private var INSTANCE: LugarDatabaseComida? = null

        fun getDatabase(context: android.content.Context) : LugarDatabaseComida {
            val temp = INSTANCE
            if (temp!=null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LugarDatabaseComida::class.java,
                    "lugar_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}