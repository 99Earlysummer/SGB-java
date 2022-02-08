package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-24 9:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
}
