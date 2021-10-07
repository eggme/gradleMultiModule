package com.example.samplemodule1.map

//import com.example.samplemodule1.entity.User
//import com.example.samplemodule1.dto.UserDTO
import com.example.samplemodule1.dto.MemberDTO
import com.example.samplemodule1.entity.Member
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface MemberMapper {

    fun toMember(memberDTO: MemberDTO?): Member
    fun toDTO(member: Member?): MemberDTO
}