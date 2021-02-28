package com.ivanli.guess

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {
    val sercetNumber = SecrectNumber();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(findViewById(R.id.toolbar))
        Log.d("MainActivity","number=${sercetNumber.sercet}")

        counter.setText(sercetNumber.count.toString())

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.Replay))
                .setMessage(getString(R.string.areyoursure))
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    sercetNumber.reset()
                    counter.setText(sercetNumber.count.toString())
                    ed_number.setText("")
                }
                .setNegativeButton(getString(R.string.Cancel),null)
                .show()
        }
    }
    fun check(view : View){
        val n = ed_number.text.toString().toInt()
        println("number:${n}")
        val diff = sercetNumber.validate(n)
        var msg =getString(R.string.You_Got_It)
        if(diff < 0 ){
            msg = getString(R.string.Big)
        }else if (diff > 0){
            msg = getString(R.string.small)
        }
        counter.setText(sercetNumber.count.toString())
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.message))
            .setMessage(msg)
            .setPositiveButton(getString(R.string.ok),null)
            .show()

    }
}