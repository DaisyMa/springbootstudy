package com.myl.test.springbootstudy.controller;

import com.myl.test.springbootstudy.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Log4j
@RestController
@Api(value="/v1",description = "This is first springboot mybatis demo")
@RequestMapping("/v1")
public class Demo {

    @Autowired //启动器加载
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "get user count",httpMethod = "GET")
    public int getUserCount(){
         return template.selectOne("getUserCount");   //statement 为mysql.xml中id
    }

    @RequestMapping(value = "/addUser",method =RequestMethod.POST )
    @ApiOperation(value = "test add user",httpMethod = "POST")
    public int addUser(@RequestBody User user){
//        int result=template.insert("addUser",user);
//        return result;
         return template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "test update user",httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ApiOperation(value = "test del user",httpMethod = "POST")
    public int delUser(@RequestParam int id){
         return template.delete("deleteUser",id);
    }

}
