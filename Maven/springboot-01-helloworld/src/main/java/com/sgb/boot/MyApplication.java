package com.sgb.boot;

import org.springframework.boot.SpringApplication;
/**
 * 主程序类
 * */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 沈功波
 */
/*@RestController
@EnableAutoConfiguration*/
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}


