package com.xhq.coronavirus.entity;/*
Created by shkstart on 2020/3/15.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class User implements UserDetails {
    private int id;
    private String name;
    private String username;
    private String password;
    private List<Authentication> authenticationList;
    private String phone;
    private String unit;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Authentication at : authenticationList){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+at.getName()));
        }
        return authorities;
    }

    /**
     * 判断账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    /**
     * 判断账户是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断密码是否过期
     * 可以根据业务逻辑或者数据库字段来决定
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账户是否可用
     * 可以根据业务逻辑或者数据库字段来决定
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
