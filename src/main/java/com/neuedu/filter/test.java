package com.neuedu.filter;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        try {
            //创建C3P0
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cloudfactory?useUnicode=true&characterEncoding=UTF-8");
            dataSource.setUser("root");
            dataSource.setPassword("1234");
            Connection connection = dataSource.getConnection();
            System.out.println(connection);


            String sql = "select * from user ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                String name = resultSet.getString(3);
                String score = resultSet.getString(4);
                System.out.println("-"+name+"-"+score);
            }
            //还回到数据库连接池中
            connection.close();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
