package com.myl.test.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;

/**
 * 启动程序写法一
 */

@SpringBootApplication
@RestController("com.myl.test.springbootstudy")
public class SpringbootstudyApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootstudyApplication.class, args);
    }

}
/**
 * 启动程序写法二
 */
//@EnableScheduling
//@SpringBootApplication
//public class SpringbootstudyApplication{
//    private static ConfigurableApplicationContext context;
//    public static void main(String[] args){
//        SpringbootstudyApplication.context=SpringApplication.run(Application.class,args);
//    }
//    @PreDestroy
//    public void close(){
//        SpringbootstudyApplication.context.close();
//    }
//}