package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp
import java.time.LocalDateTime


data class ErrorResponse (
    @field:JsonProperty("result_code")
    var resultCode: String? = null,

    @field:JsonProperty("http_status")
    var httpStatus: String? = null,

    var message: String? = null,
    var path: String? = null,
    var timestamp:LocalDateTime? = null,
    var errors:MutableList<CustomError>? = mutableListOf()
)

data class CustomError(
    var field:String? = null,
    var message:String? = null
)