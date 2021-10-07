package com.example.samplemodule1.handler

import com.example.samplemodule1.entity.MemberPassword
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import org.apache.ibatis.type.TypeHandler
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

@MappedTypes(MemberPassword::class)
class PasswordEncodingHandler: TypeHandler<MemberPassword> {

    var messageDigest: MessageDigest? = null
    // PreparedStatement -> JDBC의 PreparedStatement -> ps.setString(index, value); -> ps.setString(?, ?) 로 매핑
    override fun setParameter(ps: PreparedStatement?, i: Int, parameter: MemberPassword?, jdbcType: JdbcType?) {
        println("password = ${parameter?.password}")
        messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest?.update(parameter?.password?.toByteArray())
        val hex: String = String.format("%064x", BigInteger(1, messageDigest?.digest()))
        ps?.setString(i, hex)
    }
    // 컬럼명으로 ResultSet에 접근할 때 객체로 바인딩해주는 함수
    override fun getResult(rs: ResultSet?, columnName: String?): MemberPassword {
        val memberPassword = MemberPassword()
        memberPassword.password = rs?.getString(columnName)
        return memberPassword
    }
    // 컬럼순서로 ResultSet에 접근할 때 객체로 바인딩해주는 함수
    override fun getResult(rs: ResultSet?, columnIndex: Int): MemberPassword {
        val memberPassword = MemberPassword()
        memberPassword.password = rs?.getString(columnIndex)
        return memberPassword
    }
    // CallableStatememt -> ibatis에서 프로시저를 호출할 때 사용되는 클래스
    override fun getResult(cs: CallableStatement?, columnIndex: Int): MemberPassword {
        val memberPassword = MemberPassword()
        memberPassword.password = cs?.getString(columnIndex)
        return memberPassword
    }
}