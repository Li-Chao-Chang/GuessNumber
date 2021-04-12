package com.ivanli.guess.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)//如insert重複,就取代他
    fun insert(record: Record)

    @Query(value = "select * from record")//於編寫時會自動偵測是否寫法有誤
    fun  getAll():List<Record>
}