package com.neuedu.utils;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = JDBCTools.getConnection();
        System.out.println(connection);
    }
}
