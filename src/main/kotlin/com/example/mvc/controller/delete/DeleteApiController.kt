package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated // 벨리데이션 지정 시 필수(java bean으로인식?)
class DeleteApiController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @Size(min = 2, max = 5)
        @NotNull(message = "값이 누락되었음")
        @RequestParam name:String,

        @NotNull(message = "값이 누락되어있음")
        @Min(value = 20, message = "age 20보다 커야함")
        @RequestParam age:String
    ): String {
        println("$name $age")
        return "delete-mapping"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(@PathVariable age: String, @PathVariable name: String): String {
        println("$name $age")
        return "delete-mapping-path"
    }
}