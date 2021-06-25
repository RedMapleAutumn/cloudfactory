package com.neuedu.repository;

import com.neuedu.entity.Admin;

import java.util.List;

public interface UserRepository {
    public Admin login(String username,String password);

    public String checkAccount(String account);

    public String agencylogon(String account, String password, String name, String tel, String type);

    public String factoryadminlogon(String account, String password, String name, String tel, String type,
                                    String factroyname, String factoryintro,String FNO);

    public List<Admin> findAll();

    public List<Admin> findAllByUsername(String username);

    public Admin findByAccount(String account);

    public String updateUser(String name,String tel,String account);

    public String deleteUser(String account);
}
