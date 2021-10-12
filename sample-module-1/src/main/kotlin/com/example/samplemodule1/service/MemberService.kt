package com.example.samplemodule1.service

import com.example.samplecore.dto.MemberDTO
import com.example.samplecore.entity.MemberEntity
import com.example.samplecore.map.MemberMapper
import com.example.samplecore.reposiroty.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class MemberService(
    @Autowired var memberRepository: MemberRepository,
    @Autowired var memberMapper: MemberMapper,
    @Autowired var memberMybatis: com.example.samplemodule1.mapper.MemberMapper
        ){
        /**
         * 멤버를 저장하는 함수
         */
        fun saveMember(memberDTO: MemberDTO): MemberEntity?{
                var savedMember = memberMapper.toMember(memberDTO).apply{
                    memberRepository.save(this!!)
                }
                return savedMember
        }

        /**
         * 멤버를 jpa를 사용하여 모두 조회하는 함수
         */
        fun getMemberList(pageable: Pageable): MutableList<MemberEntity>?{
            val memberList : MutableList<MemberEntity>
            // 기존 JpaRepository에서 CrudRepository로 변경할 예정
                //val findAllMemberList = memberRepository.findAll(pageable)
                //return findAllMemberList
            return null
        }

        /**
         * 멤버를 mybatis를 사용하여 모두 조회하는 함수
         */
        fun getMemberListMybatis(): List<MemberEntity>{
                return memberMybatis.getMemberList()
        }

        fun updateMember(member: MemberEntity): MemberDTO? {
                val updatedMemberId = memberMybatis.updateMember(member)
                val savedMember = memberRepository.findByIdOrNull(member.mno)
                return memberMapper.toDTO(savedMember)
        }

}