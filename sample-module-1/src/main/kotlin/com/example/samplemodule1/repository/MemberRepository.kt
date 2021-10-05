package com.example.samplemodule1.repository

import com.example.samplemodule1.entity.Member
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: JpaRepository<Member, Long> {

    @Query("select m from Member m")
    fun findAllMember(): List<Member>;
}