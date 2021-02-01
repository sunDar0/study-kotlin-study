package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

//contoller 사용 시 static 아래 html 을 찾음
@Controller
class PageController {
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody // contoller내 에서 html이 아닌 response를 내려야할 경우 사용 할 수 있음
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "hi"
        }
    }
}