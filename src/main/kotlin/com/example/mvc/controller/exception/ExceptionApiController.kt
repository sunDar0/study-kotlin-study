package com.example.mvc.controller.exception

import com.example.mvc.model.http.CustomError
import com.example.mvc.model.http.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import javax.validation.ConstraintViolationException
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api/exception")
@Validated
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello()
    {
        val list = mutableListOf<String>()
        val temp = list[0]
    }

    @GetMapping("")
    fun get(
        @NotBlank
        @Size(min = 2, max = 6)
        @RequestParam name: String,

        @Min(10)
        @RequestParam age: Int
    ): String{
        println(name)
        println(age)
        return "$name $age"
    }


    @ExceptionHandler(value=[ConstraintViolationException::class])
    fun constraintViolationException(e: ConstraintViolationException): ResponseEntity<ErrorResponse>
    {
        // TODO: 2021/01/26 에러 분석
        var errors = mutableListOf<CustomError>()
        e.constraintViolations.forEach {
            val field = it.propertyPath.last().name
            val message = it.message
            val error = CustomError().apply {
                this.field = field
                this.message = message
            }
            errors.add(error)
        }

        //
        var errorResponse = ErrorResponse().apply {
            this.resultCode = ""
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.message = "요청에 에러 발생"
            this.path = ""
            this.timestamp
        }
    }

    //컨트롤러 내부에서 익셉션 핸들러를 지정 할 수 있음
    @ExceptionHandler(value=[IndexOutOfBoundsException::class]) //특정 예외처리 캐치
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String>
    {
        println("하위하위")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("index Error!!")
    }
}