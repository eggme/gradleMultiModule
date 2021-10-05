package com.example.samplemodule1.controller

import com.example.samplemodule1.dto.MemberDTO
import com.example.samplemodule1.entity.Member
import com.example.samplemodule1.map.MemberMapper as MemberMapstruct
import com.example.samplemodule1.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
            @Autowired var memberService: MemberService,
            @Autowired var memberMapper: MemberMapstruct
        ){

    @GetMapping(value = ["/member"])
    fun getMember(@RequestBody memberDTO: MemberDTO): MemberDTO {
        println("Binding to ModelAttribute = $memberDTO")
        val saveMember = memberService.saveMember(memberDTO)
        println("saved Member to DataBase value = $saveMember")
        val convertMemberToDTO = memberMapper.toDTO(saveMember)
        println("convert Member to MemberDTO = $convertMemberToDTO")
        return convertMemberToDTO
    }

    @GetMapping(value = ["/members"])
    fun getMemberList(@PageableDefault(size = 5, sort=["name"], direction = Sort.Direction.ASC)
                      pageable: Pageable): MutableList<Member> {
        println(pageable)
        val pageObj = memberService.getMemberList(pageable)
        val memberList = pageObj.content.toMutableList()

        return memberList;
    }

    @GetMapping(value = ["/memberMybatis"])
    fun getMemberListMybatis(): List<Member>{
        return memberService.getMemberListMybatis()
    }
}