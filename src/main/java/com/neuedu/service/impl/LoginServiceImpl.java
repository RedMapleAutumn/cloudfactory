package com.neuedu.service.impl;

import com.neuedu.entity.Admin;
import com.neuedu.repository.UserRepository;
import com.neuedu.repository.impl.UserRepositoryImpl;
import com.neuedu.service.LoginService;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class LoginServiceImpl implements LoginService {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public Admin login(String username, String password) {
        Admin admin = userRepository.login(username,password);
        sqlSession.close();
        return admin;
    }
}
