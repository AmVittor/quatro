package com.mycompany.quatro.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class ConnectionMysql {
    private JdbcTemplate mysql;

    public ConnectionMysql() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.17.0.2:3306/4four?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");

        mysql = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getMysql() {
        return mysql;
    }
}
