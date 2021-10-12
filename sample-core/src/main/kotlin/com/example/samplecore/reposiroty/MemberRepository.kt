package com.example.samplecore.reposiroty

import com.example.samplecore.entity.MemberEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: CrudRepository<MemberEntity, Int>{
    fun findByUserId(userId: String?): MemberEntity?
    fun findAllMemberEntity(): List<MemberEntity>
}