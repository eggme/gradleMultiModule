package com.example.samplecore.reposiroty

import com.example.samplecore.entity.MemberRoleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRoleRepository : CrudRepository<MemberRoleEntity, Int>{
    fun findAllByMbno(mbno: Int?): MutableList<MemberRoleEntity>
}