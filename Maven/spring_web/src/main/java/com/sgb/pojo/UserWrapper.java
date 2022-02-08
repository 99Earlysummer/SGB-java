package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

/**
 * @author ***
 * @create 2021-12-30 14:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWrapper {
    /**
     * 页面返回得值存在uer中再将user包装到此类中
     */
    private User user;
}
