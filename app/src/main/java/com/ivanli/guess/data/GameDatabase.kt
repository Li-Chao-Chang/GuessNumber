package com.ivanli.guess.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//如多個資料表則arrayOf(Record::class,Word::class,OOXX::class)
@Database(entities = arrayOf(Record::class),version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun recordDao():RecordDao
    companion object{
        private  var instance : GameDatabase? = null
        fun getInstance(context: Context) : GameDatabase?{
            if(instance == null){
                instance = Room.databaseBuilder(context,
                    GameDatabase ::class.java,"guessgmae.db")
                    .build()
            }
            return instance
        }
    }
}