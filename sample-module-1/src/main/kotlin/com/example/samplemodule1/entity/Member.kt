package com.example.samplemodule1.entity

import com.example.samplemodule1.handler.JsonArrayConverter
import com.example.samplemodule1.handler.JsonObjectConverter
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity @Table(name="MEMBER")
data class Member (
    @Id @GeneratedValue @Column(name="mno") var mno: Long = 0L,
    ){
    var email: String? = null
    @Column(length = 20) var name: String? = null
    var age: Int? = null
    var tel: String? = null
    /* JsonObject Convert 테스트용 */
    @Convert(converter = JsonObjectConverter::class) @Column(name="temp") var temp: JsonObject? = null
    /* JsonArray Convert 테스트용 */
    @Convert(converter = JsonArrayConverter::class) @Column(name="messages") var messages: JsonArray? = null
    /* ManyToOne 테스트용 */
    @ManyToOne(cascade = [CascadeType.ALL]) @JoinColumn(name="eno") var event: Event? = null
    /* OneToMany 테스트용 */
    @Column(length = 200) var address: String? = null
    @CreatedDate @Column(name = "create_at") var createAt: LocalDateTime? = null
    @LastModifiedDate @Column(name = "modify_at")var modifyAt: LocalDateTime? = null
    @Embedded var password: MemberPassword? = null
}