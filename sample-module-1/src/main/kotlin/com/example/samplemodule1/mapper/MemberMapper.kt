package com.example.samplemodule1.mapper

import com.example.samplemodule1.entity.Member
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component

@Mapper
@Component
interface MemberMapper {

    fun getMemberList(): List<Member>
}