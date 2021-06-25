package com.neuedu.repository.impl;

import com.neuedu.entity.Admin;
import com.neuedu.entity.Factory;
import com.neuedu.repository.FactoryRepository;
import com.neuedu.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactoryRepositoryImpl implements FactoryRepository {
    @Override
    public String checkFNO(String FNO) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from factory where FNO = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,FNO);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = "编号存在";
            }else {
                result = "编号不重复";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public String insert(String FNO, String Fname, String Fintro, String account) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into factory(FNO,Fname,Fintro,FAccount) values (?,?,?,?) ";
        PreparedStatement preparedStatement = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,FNO);
            preparedStatement.setString(2,Fname);
            preparedStatement.setString(3,Fintro);
            preparedStatement.setString(4,account);
            preparedStatement.executeUpdate();
            result = "插入成功";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return result;
    }

    @Override
    public List<Factory> findAll() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select FName,FIntro,FAccount,Name,Tel,FState,factory.FNO from user,factory where FAccount=Account ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Factory factory = null;
        List<Factory> list =  new ArrayList<Factory>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                factory = new Factory(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7));
                list.add(factory);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Factory> findAllByName(String fname) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select FName,FIntro,FAccount,Name,Tel,FState,factory.FNO from user,factory where FAccount=Account and FName = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Factory factory = null;
        List<Factory> list =  new ArrayList<Factory>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,fname);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                factory = new Factory(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7));
                list.add(factory);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Factory findByFNO(String FNO) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select FName,FIntro,FAccount,Name,Tel,FState,factory.FNO from user,factory where FAccount=Account and factory.FNO = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Factory factory = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,FNO);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                factory = new Factory(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return factory;
    }

    @Override
    public String changeFactoryState(String FNO, String state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update factory set FState = ? where FNO = ?";
        PreparedStatement preparedStatement = null;
        Factory factory = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,state);
            preparedStatement.setString(2,FNO);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return "更新成功";
    }


}
