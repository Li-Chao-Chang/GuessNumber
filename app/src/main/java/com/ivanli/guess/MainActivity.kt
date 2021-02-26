package com.ivanli.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val sercetNumber = SecrectNumber();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","number=${sercetNumber.sercet}")
    }

    fun check(view : View){
        val n = ed_number.text.toString().toInt()
        println("number:${n}")
        val diff = sercetNumber.validate(n)
        var msg ="你猜對了！！"
        if(diff<0){
            msg = "再大點！！"
        }else if (diff > 0){
            msg = "再小點！！"
        }
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(msg)
            .setPositiveButton("ok",null)
            .show()

    }
}
