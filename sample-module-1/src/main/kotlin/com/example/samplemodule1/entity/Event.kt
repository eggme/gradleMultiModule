package com.example.samplemodule1.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Event (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="eno") var eno: Long? = 0){
    var name: String? = null
    @CreatedDate var createAt: LocalDateTime? = null;
    @LastModifiedDate var modifyAt: LocalDateTime? = null;
}

/**
 *  이벤트 이름
 *  이벤트 시간
 */