package com.ivanli.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.ed_number
import kotlinx.android.synthetic.main.content_material.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var viewMode: GuessViewModel//onCreate後生成
    val sercetNumber = SecrectNumber();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","number=${sercetNumber.sercet}")

        viewMode = ViewModelProvider(this).get(GuessViewModel::class.java)
        viewMode.counter.observe(this, Observer {data -> //Default命名為it,data為自定義
            counter.setText(data.toString())
        })
    }

    fun check(view : View){
        viewMode.guess(ed_number.text.toString().toInt())
        /*
        val n = ed_number.text.toString().toInt()
        println("number:${n}")
        val diff = sercetNumber.validate(n)
        var msg =getString(R.string.You_Got_It)
        if(diff < 0 ){
            msg = getString(R.string.Big)
        }else if (diff > 0){
            msg = getString(R.string.small)
        }
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(msg)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
         */

    }
}
