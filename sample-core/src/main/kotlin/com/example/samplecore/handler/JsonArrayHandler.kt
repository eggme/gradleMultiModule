package com.example.samplecore.handler

import com.google.gson.Gson
import com.google.gson.JsonArray
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import org.apache.ibatis.type.TypeHandler
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

@MappedTypes(JsonArray::class)
class JsonArrayHandler: TypeHandler<JsonArray?> {

    private val gson = Gson()

    override fun setParameter(ps: PreparedStatement?, i: Int, parameter: JsonArray?, jdbcType: JdbcType?) {
        println("JsonArray = ${parameter.toString()}")
        ps?.setString(i, parameter.toString()?: "")
    }

    override fun getResult(rs: ResultSet?, columnName: String?): JsonArray? {
        return gson.fromJson(rs?.getString(columnName?: ""), JsonArray::class.java)?: JsonArray()
    }

    override fun getResult(rs: ResultSet?, columnIndex: Int): JsonArray? {
        return gson.fromJson(rs?.getString(columnIndex)?: "", JsonArray::class.java)
    }

    override fun getResult(cs: CallableStatement?, columnIndex: Int): JsonArray? {
        return gson.fromJson(cs?.getString(columnIndex)?: "", JsonArray::class.java)
    }
}