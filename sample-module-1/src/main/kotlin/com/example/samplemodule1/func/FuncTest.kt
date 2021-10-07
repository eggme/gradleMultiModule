package com.example.samplemodule1.func

class FuncTest {

    fun increase(num: Int) : Int {
        println("num is $num")
        return num + 10
    }

    fun apply(name: String, body: (Int) -> Int): Int {
        println("name $name")
        return body(3)
    }
}
