package com.example.samplemodule1.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity @Table(name="MEMBER")
data class Member constructor(
    @Id @GeneratedValue var id: Long = 0L,
    var name: String = "",
    var age: Int = 0
    ){
}
