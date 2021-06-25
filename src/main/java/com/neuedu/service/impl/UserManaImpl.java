package com.neuedu.service.impl;

import com.neuedu.entity.Admin;
import com.neuedu.repository.UserRepository;
import com.neuedu.repository.impl.UserRepositoryImpl;
import com.neuedu.service.UserMana;

import java.util.List;

public class UserManaImpl implements UserMana {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<Admin> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Admin> findAllByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

    @Override
    public Admin findByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    @Override
    public String updateUser(String name, String tel,String account) {
        return userRepository.updateUser(name,tel,account);
    }

    @Override
    public String deleteUser(String account) {
        return userRepository.deleteUser(account);
    }
}
