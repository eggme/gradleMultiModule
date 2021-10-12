package com.example.samplemodule1.func

import com.example.samplemodule1.dto.MemberDTO
import com.example.samplemodule1.entity.Member
import com.example.samplemodule1.entity.MemberPassword
import com.example.samplemodule1.map.MemberMapper
import com.example.samplemodule1.service.MemberService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Component

@Component
class AddMember (
    @Autowired var memberService: MemberService,
    @Autowired var memberMapper: MemberMapper,
    @Autowired var conversionService: ConversionService
        ): ApplicationRunner{

    private var logger = LoggerFactory.getLogger(AddMember::class.java)


    override fun run(args: ApplicationArguments?) {
        logger.error(conversionService::class.java.toString())

        val memberNameList = listOf(
            Triple("이승준", 26, MemberPassword("1234")),
            Triple("김승준",25, MemberPassword("4412")),
            Triple("신승준", 33, MemberPassword("5351")),
            Triple("강승준", 28, MemberPassword("13123")),
            Triple("조승준", 30, MemberPassword("1351535")),
            Triple("원승준", 44, MemberPassword("13ff31")),
            Triple("최승준", 22, MemberPassword("d1c13")),
            Triple("문승준", 29, MemberPassword("c1313")),
            Triple("박승준", 38, MemberPassword("1e12e")))

        memberNameList.forEach {
            val memberDTO = MemberDTO()
            memberDTO.name = it.first
            memberDTO.age = it.second
            memberDTO.password = it.third
            val savedMember = memberService.saveMember(memberDTO)
            logger.info(memberMapper.toDTO(savedMember).toString());
        }
    }
}