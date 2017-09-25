package com.kushmiruk.chapter06.dao;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static DataSource getOracleDataSource() {
        OracleDataSource oracleDS = null;
        try {
            oracleDS = new OracleDataSource();
            oracleDS.setDriverType("oracle.jdbc.driver.OracleDriver");
            oracleDS.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            oracleDS.setUser("Roman");
            oracleDS.setPassword("231094");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oracleDS;
    }

    public static Connection getConnection() {
        try {
            return getOracleDataSource().getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error connection");
        }
    }
}
