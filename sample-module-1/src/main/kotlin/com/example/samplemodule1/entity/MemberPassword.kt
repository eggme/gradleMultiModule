package com.example.samplemodule1.entity

import javax.persistence.Embeddable

@Embeddable
class MemberPassword constructor (var password: String? = null) {
    override fun toString(): String {
        return "${this.javaClass.simpleName}(password=$password)"
    }
    constructor(): this("")
}
