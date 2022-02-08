package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Map;

/**
 * @author ***
 * @create 2021-12-30 14:31
 * 见demo07.html
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String stuName;
    private School school;
    private List<Subject> subjectList;
    private Map<String,Double> scores;
}
