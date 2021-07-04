package com.neuedu.repository;

import com.neuedu.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRepository {
    public Admin login(@Param("username") String username, @Param("password") String password);

    public String checkAccount(@Param("account") String account);

    public int agencylogon(@Param("account") String account, @Param("password") String password,
                              @Param("name") String name, @Param("tel") String tel,@Param("type") String type);

    public int factoryadminlogon(@Param("account") String account, @Param("password") String password,
                                    @Param("name") String name, @Param("tel") String tel,@Param("type") String type,
                                    @Param("fname") String factroyname, @Param("fintro") String factoryintro,
                                    @Param("FNO") String FNO);

    public List<Admin> findAll();

    public List<Admin> findAllByUsername(@Param("username") String username);

    public Admin findByAccount(@Param("account") String account);

    public int updateUser(@Param("name") String name,@Param("tel") String tel,@Param("account") String account);

    public int deleteUser(@Param("account") String account);
}
