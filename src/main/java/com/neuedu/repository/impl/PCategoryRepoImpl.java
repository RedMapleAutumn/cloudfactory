package com.neuedu.repository.impl;

import com.neuedu.entity.Factory;
import com.neuedu.entity.ProductCategory;
import com.neuedu.repository.PCategoryRepo;
import com.neuedu.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PCategoryRepoImpl implements PCategoryRepo {
    @Override
    public List<ProductCategory> findAll() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from productcategory";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductCategory productCategory = null;
        List<ProductCategory> list =  new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productCategory = new ProductCategory(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                list.add(productCategory);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public String checkFCNO(String PCNO) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from productcategory where PCNO = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,PCNO);
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
    public int add(String PCNO,String name) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into productcategory(PCNO,PCName) values (?,?)";
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,PCNO);
            preparedStatement.setString(2,name);
            preparedStatement.executeUpdate();
            result = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return result;
    }

    @Override
    public List<ProductCategory> findAllByName(String name) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from productcategory where PCName = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductCategory productCategory = null;
        List<ProductCategory> list =  new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productCategory = new ProductCategory(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                list.add(productCategory);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }
}
