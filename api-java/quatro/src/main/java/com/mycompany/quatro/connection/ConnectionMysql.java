package com.mycompany.quatro.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class ConnectionMysql {
    private JdbcTemplate mysql;

    public ConnectionMysql() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/meubanco");
        dataSource.setUsername("meulogin");
        dataSource.setPassword("minhasenha");

        mysql = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getMysql() {
        return mysql;
    }
}
