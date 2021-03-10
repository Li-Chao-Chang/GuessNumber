package com.ivanli.guess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class GuessViewModel : ViewModel() {
    var secrect :Int = 0
    var count : Int = 0
    val counter = MutableLiveData<Int>()
    var result = MutableLiveData<GameResult>()
    init {
        counter.value = count
        reset()
    }

    fun guess(num:Int )
    {
        count++
        counter.value = count
        result.value = when(num - secrect){
            0 -> GameResult.NUMBER_RIGHT
            in 1..Int.MAX_VALUE -> GameResult.SMALLER
            else -> GameResult.BIGGER
        }
    }

    fun reset()
    {
        secrect = Random().nextInt(10)+1
        count = 0
    }
}
enum class GameResult
{
    BIGGER,SMALLER,NUMBER_RIGHT
}