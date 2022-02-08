package com.sgb.configuration;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("jdbc.properties")
public class MySpringDaoConfiguration {


    @Value("${driverClassName}")
    private String driverClassName ;

    @Value("${url}")
    private String url ;

    @Value("${user}")
    private String user ;

    @Value("${password}")
    private String password ;

    @Bean
    public QueryRunner getQueryRunner(DataSource ds){
        return new QueryRunner(ds);
    }

    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}
