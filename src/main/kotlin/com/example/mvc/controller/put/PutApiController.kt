package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.lang.StringBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @PutMapping(path = ["/put-mapping/object"])
    //부분 검증 시 @Valid 추가
    fun putMappingObj(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        //BindingResult 벨리데이션 결과를 가져올수 있음
        if(bindingResult.hasErrors()){
            var msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field+" "+message+"\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("OKOK")
        // 스코프 연산자
        //apply, run, with, also, let

//        return UserResponse().apply {// apply 인스턴스 초기화 후 리턴
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//            }
//        }.apply {
//            this.description = "~~~~~~~~~~~~~~~~~"
//        }.apply {
//            val userList = mutableListOf<UserRequest>()
//            userList.add(userRequest)
//            userList.add(UserRequest().apply {
//                this.name = "aa"
//                this.age  = 300
//                this.email = "aaa@bbb.ccc"
//                this.addr = "서울 1번"
//                this.phoneNumber = "111-1111-1111"
//            })
//            userList.add(UserRequest().apply {
//                this.name = "bb"
//                this.age  = 444
//                this.email = "eee@fff.ggg"
//                this.addr = "서울 2번"
//                this.phoneNumber = "222-2222-2222"
//            })
//            this.userRequest = userList
//        }
    }
}