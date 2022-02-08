package com.sgb.configuration;



import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("com.sgb")//扫描注解
@Import(MySpringDaoConfiguration.class)
public class MySpringCoreConfiguration {



}
