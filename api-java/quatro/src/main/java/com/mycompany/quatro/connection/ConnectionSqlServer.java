package com.mycompany.quatro.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionSqlServer {
    private JdbcTemplate mssql;

    public ConnectionSqlServer() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://quatro-server.database.windows.net:1433;database=quatro_db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        dataSource.setUsername("quatro");
        dataSource.setPassword("2ads$grupo3");

        mssql = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getMssql() {
        return mssql;
    }
}
