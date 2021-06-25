package com.neuedu.service.impl;

import com.neuedu.entity.Admin;
import com.neuedu.repository.UserRepository;
import com.neuedu.repository.impl.UserRepositoryImpl;
import com.neuedu.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository = new UserRepositoryImpl();
    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public Admin login(String username, String password) {
        Admin admin = userRepository.login(username,password);
        return admin;
    }
}
