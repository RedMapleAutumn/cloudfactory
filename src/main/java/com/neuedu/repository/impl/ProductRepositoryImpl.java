package com.neuedu.repository.impl;

import com.neuedu.entity.Product;
import com.neuedu.entity.ProductCategory;
import com.neuedu.repository.ProductRepository;
import com.neuedu.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from product,productcategory where product.Pcno=productcategory.PCNO";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> list =  new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new Product(resultSet.getString(1),resultSet.getString(2),resultSet.getString(8),
                        resultSet.getString(4),resultSet.getString(5));
                list.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public String checkPNO(String PNO) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from product where PNO = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,PNO);
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
    public int add(String PNO, String name, String PCNO, String size, String description) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into product(PNO,PName,Pcno,PSize,PDes) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        String result = "";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,PNO);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,PCNO);
            preparedStatement.setString(4,size);
            preparedStatement.setString(5,description);
            preparedStatement.executeUpdate();
            result = "插入成功";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
        return 1;
    }
}
