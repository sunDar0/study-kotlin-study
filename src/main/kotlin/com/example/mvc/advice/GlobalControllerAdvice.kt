package com.example.mvc.advice

import com.example.mvc.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//RestController에서 발생하는 Exception을 잡는 클래스
//@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class]) // 특정 컨트롤러나 어노테이션을 지정할 수 있음
@ControllerAdvice // controller advice도 있음
class GlobalControllerAdvice {

    @ExceptionHandler(value=[RuntimeException::class]) //특정 예외처리 캐치
    fun runTimeException(e: RuntimeException): String
    {
        return "Server Error!"
    }

    @ExceptionHandler(value=[IndexOutOfBoundsException::class]) //특정 예외처리 캐치
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String>
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("index Error!!")
    }


}