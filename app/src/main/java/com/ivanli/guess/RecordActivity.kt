package com.ivanli.guess

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.ivanli.guess.data.GameDatabase
import com.ivanli.guess.data.Record
import kotlinx.android.synthetic.main.activity_record.*
import kotlinx.android.synthetic.main.content_material.*

class RecordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val count = intent.getStringExtra("COUNTER")
        txt_count.setText(count)

        btn_record.setOnClickListener{
            //Room
            GameDatabase.getInstance(this)
            val record = Record(edit_name.text.toString(),count.toInt())
            Thread(){
                GameDatabase.getInstance(this)?.recordDao()?.insert(record)
            }.start()
            //Room read test

            var intent = Intent(this,MaterialActivity::class.java)
            intent.putExtra("RESET",true)
            startActivity(intent)
        }
    }
}