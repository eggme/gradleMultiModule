package com.example.samplecore.map

import com.example.samplecore.dto.MemberDTO
import com.example.samplecore.entity.MemberEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Repository

@Mapper(componentModel = "spring")
@Repository
interface MemberMapper {

    fun toMember(memberDTO: MemberDTO?): MemberEntity?
    fun toDTO(member: MemberEntity?): MemberDTO?
}