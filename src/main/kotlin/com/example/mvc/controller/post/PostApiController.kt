package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String
    {
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String
    {
        return "request-mapping"
    }

    //object mapper 사용
    //json -> object
    //object -> json
    @PostMapping("/post-mapping/obj")
    fun postMappingObj(@RequestBody userRequest: UserRequest): UserRequest
    {
        println(userRequest)
        return userRequest
    }

}