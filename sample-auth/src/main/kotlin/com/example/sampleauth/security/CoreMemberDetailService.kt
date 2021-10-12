package com.example.sampleauth.security

import com.example.samplecore.reposiroty.MemberRepository
import com.example.samplecore.reposiroty.MemberRoleRepository
import com.example.samplecore.security.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CoreMemberDetailService: UserDetailsService {
    @Autowired private lateinit var memberRepository: MemberRepository
    @Autowired private lateinit var memberRoleRepository: MemberRoleRepository

    override fun loadUserByUsername(username: String?): UserDetails? {
        val member = memberRepository.findByUserId(username) ?: throw UsernameNotFoundException("해당되는 유저를 찾을 수 없습니다")
        member.roles = memberRoleRepository.findAllByMbno(member.mbno)
        return User(member)
    }
}