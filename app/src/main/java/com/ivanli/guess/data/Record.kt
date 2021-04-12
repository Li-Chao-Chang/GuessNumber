package com.ivanli.guess.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Record(
    @NonNull
    @ColumnInfo(name = "Ivan")
    var nickname: String,
    @NonNull
    var counter: Int) {
    @PrimaryKey(autoGenerate = true)//自動產生整數值
    var id : Long =0
}