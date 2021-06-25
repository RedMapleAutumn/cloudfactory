package com.neuedu.service;

import com.neuedu.entity.Admin;

import java.util.List;

public interface UserMana {
    public List<Admin> findAll();

    public List<Admin> findAllByUsername(String username);

    public Admin findByAccount(String account);

    public String updateUser(String name,String tel,String account);

    public String deleteUser(String account);

}
