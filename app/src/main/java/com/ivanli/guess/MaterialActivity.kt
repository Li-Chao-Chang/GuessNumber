package com.ivanli.guess

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.ivanli.guess.data.GameDatabase
import com.ivanli.guess.data.Record
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {
    private lateinit var viewMode: GuessViewModel//onCreate後生成
    val sercetNumber = SecrectNumber();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(findViewById(R.id.toolbar))
        Log.d("MainActivity","number=${sercetNumber.sercet}")

        counter.setText(sercetNumber.count.toString())

        viewMode = ViewModelProvider(this).get(GuessViewModel::class.java)
        viewMode.counter.observe(this, Observer {data -> //Default命名為it,data為自定義
            counter.setText(data.toString())
        })
        viewMode.result.observe(this, Observer { result ->
            var message = when(result){
                GameResult.BIGGER -> getString(R.string.Big)
                GameResult.SMALLER -> getString(R.string.small)
                GameResult.NUMBER_RIGHT -> getString(R.string.You_Got_It)
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.message))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    if (message == getString(R.string.You_Got_It)){
                        var intent = Intent(this,RecordActivity::class.java)
                        intent.putExtra("COUNTER",counter.text)
                        startActivity(intent)
                    }
                }
                .show()
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.Replay))
                .setMessage(getString(R.string.areyoursure))
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    viewMode.reset()
                    ed_number.setText("")
                }
                .setNegativeButton(getString(R.string.Cancel),null)
                .show()
        }
        AsyncTask.execute{
            var list = GameDatabase.getInstance(this)?.recordDao()?.getAll()
            list?.forEach{
                Log.d("MaterialActivity","record:${it.id}${it.nickname}${it.counter}")
            }
        }
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
        counter.setText(sercetNumber.count.toString())
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.message))
            .setMessage(msg)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
         */
    }
}