package com.neuedu.service;

import com.neuedu.entity.Admin;

public interface LoginService {
    public Admin login(String username, String password);
}
