package com.neuedu.repository.impl;

import com.neuedu.entity.Admin;
import com.neuedu.entity.FactoryAdmin;
import com.neuedu.repository.UserRepository;
import com.neuedu.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    /**
     * 用户登录操作
     * @param username 账号
     * @param password 密码
     * @return 返回用户的类型
     */
    @Override
    public Admin login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from user where Account = ? and Password = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String type = resultSet.getString(5);
                if(type=="云工厂"){
                    admin = new FactoryAdmin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                            resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                }else{
                    admin = new Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                            resultSet.getString(4),resultSet.getString(5));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return admin;
    }

    /**查看用户注册时输入的账号是否重复
     * @param account 账号
     * @return 返回检测的状态
     */
    public String checkAccount(String account){
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from user where Account = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = "账号重复";
            }else {
                result = "账号不重复";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return result;
    }

    /**注册经销商的方法
     * @param account 账号
     * @param password 密码
     * @param name 真实姓名
     * @param tel 联系电话
     * @param type 注册类型
     * @return 返回数据库插入操作是否成功
     */
    @Override
    public String agencylogon(String account, String password, String name, String tel, String type) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into user(Account,Password,Name,Tel,Type) values (?,?,?,?,?) ";
        PreparedStatement preparedStatement = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,tel);
            preparedStatement.setString(5,type);
            preparedStatement.executeUpdate();
            result = "注册成功";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return result;
    }

    /**将注册的云工厂管理员信息插入user表
     * @param account
     * @param password
     * @param name
     * @param tel
     * @param type
     * @param factroyname 工厂名称
     * @param factoryintro 工厂简介
     * @param FNO 工厂编号
     * @return 数据库插入状态
     */
    @Override
    public String factoryadminlogon(String account, String password, String name, String tel, String type, String factroyname, String factoryintro,String FNO) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into user(Account,Password,Name,Tel,Type,FNO) values (?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,tel);
            preparedStatement.setString(5,type);
            preparedStatement.setString(6,FNO);
            preparedStatement.executeUpdate();
            result = "注册成功";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return result;
    }

    @Override
    public List<Admin> findAll() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from user ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        List<Admin> list =  new ArrayList<Admin>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                admin = new Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5));
                list.add(admin);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Admin> findAllByUsername(String username) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from user where Name = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        List<Admin> list =  new ArrayList<Admin>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                admin = new Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5));
                list.add(admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Admin findByAccount(String account) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from user where Account = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                admin = new Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return admin;
    }

    @Override
    public String updateUser(String name, String tel,String account) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update user set Name = ? , Tel = ? where Account = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,tel);
            preparedStatement.setString(3,account);
            int num = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return "更新成功";
    }

    @Override
    public String deleteUser(String account) {
        Connection connection = JDBCTools.getConnection();
        String sql = "delete from user where Account = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return "删除成功";
    }

}
