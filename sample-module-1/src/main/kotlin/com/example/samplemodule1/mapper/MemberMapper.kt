package com.example.samplemodule1.mapper

import com.example.samplecore.entity.MemberEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper
@Component
interface MemberMapper {

    fun getMemberList(): MutableList<MemberEntity>

    fun updateMember(member: MemberEntity)
}