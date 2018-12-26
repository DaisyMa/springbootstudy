package com.myl.test.springbootstudy.server;

import com.myl.test.springbootstudy.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "This is my post Service")
@RequestMapping("/v1")
public class MyPostService {
    private static Cookie cookie;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "login",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "username",required = true) String username,@RequestParam(value = "pwd",required = true) String pwd){
        if(username.equals("daisy")&& pwd.equals("123456")){
            Cookie cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "get user list",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
        //获取Cookies
        Cookie[] cookies=request.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("login") && c.getValue().equals("true")){
                User user=new User();
                user.setName("daisy");
                user.setStatus(1);
                user.getCreateTime();
                return user.toString();
            }
        }
        return "参数不合法";
    }

}
