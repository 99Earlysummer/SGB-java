package com.sgb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author ***
 * @create 2021-12-29 11:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2 {

    private Integer userId;
    @NotBlank(message = "账户不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String userPwd;
    @NotNull(message = "金额不能为空")
    @Min(value = 0,message = "不能过少")
    @Max(value = 1000000000,message = "过高")
    private Double money;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "不为手机号不能为空空")
    @Pattern(regexp = "[1]{1}[356789]{1}[0-9]{9}",message = "手机号格式错误!")//自定义
    private String phoneNum;
}
