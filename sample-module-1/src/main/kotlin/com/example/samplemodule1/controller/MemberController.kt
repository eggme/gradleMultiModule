package com.example.samplemodule1.controller

import com.example.samplecore.dto.MemberDTO
import com.example.samplecore.entity.MemberEntity
import com.example.samplecore.map.MemberMapper
import com.example.samplecore.reposiroty.MemberRepository
import com.example.samplemodule1.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
            @Autowired var memberService: MemberService,
            @Autowired var memberMapper: MemberMapper
        ){

    @Autowired private lateinit var memberRepository: MemberRepository

    @PostMapping(value = ["/test"])
    fun authenticationTest(@RequestBody member: MemberEntity): ResponseEntity<Any> {
        println("asdasd $member")
        return ResponseEntity.ok(hashMapOf("testUser" to member));
    }

    @PostMapping(value = ["/member"])
    fun getMember(@RequestBody memberDTO: MemberDTO): MemberDTO? {
        println("Binding to RequestBody = $memberDTO")
        val saveMember = memberService.saveMember(memberDTO)
        println("saved Member to DataBase value = $saveMember")
        val convertMemberToDTO = memberMapper.toDTO(saveMember)
        println("convert Member to MemberDTO = $convertMemberToDTO")
        return convertMemberToDTO
    }

    @PostMapping(value = ["/member/update"])
    fun updateMember(@RequestBody memberDTO: MemberDTO): MemberDTO?{
        println("controller = $memberDTO")
        return memberService.updateMember(memberMapper.toMember(memberDTO)!!)
    }

    @GetMapping(value = ["/members"])
    fun getMemberList(@PageableDefault(size = 5, sort=["name"], direction = Sort.Direction.ASC)
                      pageable: Pageable): MutableList<MemberEntity>? {
        println(pageable)
        val memberList = memberService.getMemberList(pageable)
        return memberList;
    }

    @GetMapping(value = ["/memberMybatis"])
    fun getMemberListMybatis(): List<MemberEntity>{
        return memberService.getMemberListMybatis()
    }
}