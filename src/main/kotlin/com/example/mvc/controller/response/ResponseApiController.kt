package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let{
            //age is not null
            if(it < 20){
                return ResponseEntity.badRequest().body("age 값 20보다 작음 Fail")
            }

            ResponseEntity.ok("OKOK")
        }?: kotlin.run{
            //age is null
            return ResponseEntity.badRequest().body("age값 누락 Fail")
        }
//        if(age == null) {
//            return ResponseEntity.badRequest().body("age값 누락 Fail")
//        }
//        if(age < 20){
//            return ResponseEntity.status(400).body("age 값 20보다 작음 Fail")
//        }
//        return ResponseEntity.ok("OK")
    }
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK).body(userRequest) // object mapper -> object -> json
    }

    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}