package com.neuedu.service.impl;

import com.neuedu.entity.Admin;
import com.neuedu.repository.UserRepository;
import com.neuedu.repository.impl.UserRepositoryImpl;
import com.neuedu.service.UserMana;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserManaImpl implements UserMana {
//    SqlSession sqlSession = MybatisUtils.getSqlSession();
//    UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<Admin> findAll() {
        //sqlSession.close();
        return userRepository.findAll();
    }

    @Override
    public List<Admin> findAllByUsername(String username) {
        //sqlSession.close();
        return userRepository.findAllByUsername(username);
    }

    @Override
    public Admin findByAccount(String account) {
        //sqlSession.close();
        return userRepository.findByAccount(account);
    }

    @Override
    public String updateUser(String name, String tel,String account) {
       // sqlSession.close();
        return userRepository.updateUser(name,tel,account)+"";
    }

    @Override
    public String deleteUser(String account) {
       // sqlSession.close();
        return userRepository.deleteUser(account)+"";
    }
}
