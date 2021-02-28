package com.ivanli.guess

import java.util.*

class SecrectNumber {
    var sercet : Int = Random().nextInt(10) + 1
    var count = 0;

    fun validate(number : Int) : Int{
        count++
        return number - sercet
    }

    fun reset(){
        sercet = Random().nextInt(10) + 1
        count = 0
    }
}

fun main (){
    val sercetNumber = SecrectNumber()
    println(sercetNumber.sercet)
    println(sercetNumber.validate(2))
    println("${sercetNumber.validate(2)},count:${sercetNumber.count}")
}