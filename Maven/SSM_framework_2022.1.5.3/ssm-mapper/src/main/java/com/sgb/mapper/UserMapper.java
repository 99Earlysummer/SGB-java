package com.sgb.mapper;

import com.sgb.pojo.User;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author 沈功波
 */
@Controller
public interface UserMapper {
    List<User> selectUserList() throws Exception;
}
