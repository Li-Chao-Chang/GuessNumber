package com.ivanli.guess

import java.util.*

class SecrectNumber {
    val sercet : Int = Random().nextInt(10) + 1
    var count = 0;

    fun validate(number : Int) : Int{
        return number - sercet
    }
}

fun main (){
    val sercetNumber = SecrectNumber()
    println(sercetNumber.sercet)
    println(sercetNumber.validate(2))
    println("${sercetNumber.validate(2)},count:${sercetNumber.count}")
}