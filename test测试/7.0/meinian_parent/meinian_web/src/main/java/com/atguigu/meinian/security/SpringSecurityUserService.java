package com.atguigu.meinian.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.pojo.Permission;
import com.atguigu.meinian.pojo.Role;
import com.atguigu.meinian.pojo.User;
import com.atguigu.meinian.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Date:2022/1/22
 * Description:
 * 设置自定义认证
 */
@Component
public class SpringSecurityUserService implements UserDetailsService {
//跟dao无关系  跟service只能远程访问
    @Reference
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过用户名查询用户信息
        User user = userService.findUserByUsername(username);
        //判断user是否为null
        if(user == null){
            //表示根据用户名未查询到用户信息
            return null;
        }
        //集合权限
        Set<GrantedAuthority> authorities = new HashSet<>();
        //获取用户所对应的角色
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            //获取每个角色所对应的权限
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        //表示根据用户名查询到了用户信息，则认证并授权
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}
