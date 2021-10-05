package com.example.samplemodule1.service

import com.example.samplemodule1.dto.MemberDTO
import com.example.samplemodule1.entity.Member
import com.example.samplemodule1.mapper.MemberMapper as MemberMybatis
import com.example.samplemodule1.map.MemberMapper as MemberMapperMapStruct
import com.example.samplemodule1.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class MemberService (
        @Autowired var memberRepository: MemberRepository,
        @Autowired var memberMapper: MemberMapperMapStruct,
        @Autowired var memberMybatis: MemberMybatis
        ){

        fun saveMember(memberDTO: MemberDTO): Member{
                var convertToMember = memberMapper.toMember(memberDTO)
                val savedMember = memberRepository.save(convertToMember)
                return savedMember
        }

        fun getMemberList(pageable: Pageable): Page<Member>{
                val findAllMemberList = memberRepository.findAll(pageable)
                return findAllMemberList
        }

        fun getMemberListMybatis(): List<Member>{
                return memberMybatis.getMemberList()
        }

}