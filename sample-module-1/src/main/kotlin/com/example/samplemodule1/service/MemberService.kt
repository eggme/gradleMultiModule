package com.example.samplemodule1.service

import com.example.samplemodule1.dto.MemberDTO
import com.example.samplemodule1.entity.Member
import com.example.samplemodule1.mapper.MemberMapper as MemberMybatis
import com.example.samplemodule1.map.MemberMapper as MemberMapperMapStruct
import com.example.samplemodule1.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class MemberService (
        @Autowired var memberRepository: MemberRepository,
        @Autowired var memberMapper: MemberMapperMapStruct,
        @Autowired var memberMybatis: MemberMybatis
        ){
        /**
         * 멤버를 저장하는 함수
         */
        fun saveMember(memberDTO: MemberDTO): Member{
                var convertToMember = memberMapper.toMember(memberDTO)
                val savedMember = memberRepository.save(convertToMember)
                return savedMember
        }

        /**
         * 멤버를 jpa를 사용하여 모두 조회하는 함수
         */
        fun getMemberList(pageable: Pageable): Page<Member>{
                val findAllMemberList = memberRepository.findAll(pageable)
                return findAllMemberList
        }

        /**
         * 멤버를 mybatis를 사용하여 모두 조회하는 함수
         */
        fun getMemberListMybatis(): List<Member>{
                return memberMybatis.getMemberList()
        }

        fun updateMember(member: Member): MemberDTO {
                val updatedMemberId = memberMybatis.updateMember(member)
                val savedMember = memberRepository.findByIdOrNull(member.mno)
                return memberMapper.toDTO(savedMember)
        }

}