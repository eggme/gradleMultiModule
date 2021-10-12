package com.example.samplecore.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
@IdClass(MemberRoleId::class)
@Table(name="member_role")
data class MemberRoleEntity (@Id var mbno: Int? = null, @Id var role:String? = null)

data class MemberRoleId(var mbno: Int? = null, var role:String? = null): Serializable