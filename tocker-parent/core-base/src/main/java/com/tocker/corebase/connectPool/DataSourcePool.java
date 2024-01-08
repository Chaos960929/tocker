package com.tocker.corebase.connectPool;


import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class DataSourcePool {

    @Value("spring.datasource.url")
    private String url;

    @Value("spring.datasource.username")
    private String user;

    @Value("spring.datasource.password")
    private String password;

    LinkedList<Connection> connectionPool = new LinkedList<>();

    //创建五个连接对象
    public DataSourcePool() {
        for (int i = 0; i < 5; i++) {
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionPool.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //获取连接对象
    public Connection getConnection() {
        Connection connection = connectionPool.removeFirst();
        return connection;
    }

    //放回连接对象
    public void addBack(Connection connection) {
        connectionPool.addLast(connection);
    }
}
