package com.example.samplecore.handler

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import org.apache.ibatis.type.TypeHandler
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

@MappedTypes(JsonObject::class)
class JsonObjectHandler: TypeHandler<JsonObject> {

    private val gson = Gson()

    override fun setParameter(ps: PreparedStatement?, i: Int, parameter: JsonObject?, jdbcType: JdbcType?) {
        ps?.setString(i, parameter.toString()?: "")
    }

    override fun getResult(rs: ResultSet?, columnName: String?): JsonObject {
        return gson.fromJson(rs?.getString(columnName?:""), JsonObject::class.java)?: JsonObject()
    }

    override fun getResult(rs: ResultSet?, columnIndex: Int): JsonObject {
        return gson.fromJson(rs?.getString(columnIndex)?: "", JsonObject::class.java)
    }

    override fun getResult(cs: CallableStatement?, columnIndex: Int): JsonObject {
        return gson.fromJson(cs?.getString(columnIndex)?: "", JsonObject::class.java)
    }
}