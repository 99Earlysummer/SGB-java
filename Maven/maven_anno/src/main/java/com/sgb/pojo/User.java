package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-21 9:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String  userName;
    private String userPwd;
    private Double money;
}
