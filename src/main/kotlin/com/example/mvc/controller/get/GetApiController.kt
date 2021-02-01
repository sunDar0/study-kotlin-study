package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController // REST API
@RequestMapping("/api") // :8080/api
class GetApiController {

    //    @GetMapping("/hello") // GET :8080/api/hello
    @GetMapping(path=["/hello","/other"]) // GET :8080/api/hello
    fun hello(): String
    {
        return "hello Kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path= ["/request-mapping"])
    fun requestMapping(): String
    {
        return "Request Mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String
    {
        println("$name / $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value="name") _name: String, @PathVariable(name="age") age: Int): String
    {
        val name = "local variable"
        println("$_name / $age")
        return "$_name $age"
    }

    //query-string을 각각의 파라미터로 받을 수 있음
    @GetMapping("/get-mapping/query-param") // ?name=ted@a&age=200
    fun queryParam(@RequestParam name: String, @RequestParam(value="age") age: Int): String
    {
        println("$name / $age")
        return "$name $age"
    }

    //query-string을 object 형태로 받을 수 있음
    @GetMapping("/get-mapping/query-obj") // RestController 인 경우 return이 object 인경우 json형태로 자동 변환됨
    fun queryObj(userRequest: UserRequest): UserRequest
    {
        println(userRequest)
        return userRequest
    }


    //query-string을 map 형태로 받을 수 있음
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }

}
