package com.neuedu.service;

import com.neuedu.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMana {
    public List<Admin> findAll();

    public List<Admin> findAllByUsername(String username);

    public Admin findByAccount(String account);

    public String updateUser(String name,String tel,String account);

    public String deleteUser(String account);

    public int signUp(String account,  String password,String name, String tel,  String type,
                      String factroyname,  String factoryintro);

}
