package com.myl.test.springbootstudy.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "This is my get methods") //swagger-ui 描述信息
public class MyGetService {
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)
    @ApiOperation(value="getCookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest  装请求信息的类
        //HttpServerletResponse 装响应信息的类
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "获得cookies成功";
    }

    /**
    * 要求请求携带cookies
     * */
    @RequestMapping(value="/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value="getWithCookies",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
//        if(cookies==null) 判断对象是否为空
        if(Objects.isNull(cookies)){
            return "必须携带cookies";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "携带cookie的get请求访问成功";
            }
        }
        return "必须携带cookies来请求";
    }

    /**
     * 需携带参数才能访问的get请求1
     */
    @RequestMapping(value ="/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value="RequestParam get",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("Daisy",1);
        myList.put("Ma",2);

        return myList;
    }

    /**
     * 需携带参数访问的get请求2
     * url:ip:pprt/get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value="PathVariable get",httpMethod = "GET")   //swagger-ui 相关的注解，value为该对该方法的描述
    public Map<String,Integer>myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("Daisy",1);
        myList.put("Ma",2);

        return myList;
    }

}
