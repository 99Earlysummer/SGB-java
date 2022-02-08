package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 容器注入
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bean01 {

    private String[] strs;
    private List<String> strList;
    private List<Student> studentList;
    private Set<String> strSet;
    private Map<Integer,String> map;
    private Properties properties;
}
