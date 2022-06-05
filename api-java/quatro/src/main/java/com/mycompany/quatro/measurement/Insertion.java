package com.mycompany.quatro.measurement;

import com.mycompany.quatro.connection.ConnectionMysql;
import com.mycompany.quatro.connection.ConnectionSqlServer;

public class Insertion {

    ConnectionMysql mysql = new ConnectionMysql();
    ConnectionSqlServer mssql = new ConnectionSqlServer();

    public void diskMeasurementInsertion(Long usage, String date, String uuid, String hostName) {
        mssql.getMssql().update(
            "INSERT INTO " +
                "dbo.measurement(usage, measurement_date, fk_component, usage_unit) " +
                "VALUES (" +
                "?, " +
                "?, " +
                "(SELECT id_component FROM [dbo].[component] " +
                "INNER JOIN [dbo].[server] " +
                "ON fk_server = id_server " +
                "WHERE item LIKE 'disco' " +
                "AND UUID LIKE ? " +
                "AND server_name LIKE ?), " +
                "'B')", usage, date, uuid, hostName);

        mysql.getMysql().update(
            "INSERT INTO " +
                "dbo_measurement(measurement_usage, measurement_date, fk_component, usage_unit) " +
                "VALUES (" +
                "?, " +
                "?, " +
                "(SELECT id_component FROM dbo_component " +
                "INNER JOIN dbo_server " +
                "ON fk_server = id_server " +
                "WHERE item LIKE 'disco' " +
                "AND UUID LIKE ? " +
                "AND server_name LIKE ?), " +
                "'B')", usage, date, uuid, hostName);
    }

    public void cpuMeasurementInsertion(Double usage, Double temperature, String date, String hostName) {
        mssql.getMssql().update(
                "INSERT INTO " +
                    "[dbo].[measurement](usage, temperature, measurement_date, fk_component, usage_unit, temperature_unit) " +
                    "VALUES (" +
                    "?, " +
                    "?, " +
                    "?, " +
                    "(SELECT id_component FROM [dbo].[component] " +
                    "INNER JOIN [dbo].[server] " +
                    "ON fk_server = id_server " +
                    "WHERE item LIKE 'cpu' " +
                    "AND server_name LIKE ?), " +
                    "'%', " +
                    "'C°')", usage, temperature, date, hostName);

        mysql.getMysql().update(
                    "INSERT INTO " +
                        "dbo_measurement(measurement_usage, temperature, measurement_date, fk_component, usage_unit, temperature_unit) " +
                        "VALUES (" +
                        "?, " +
                        "?, " +
                        "?, " +
                        "(SELECT id_component FROM dbo_component " +
                        "INNER JOIN dbo_server "  +
                        "ON fk_server = id_server " +
                        "WHERE item LIKE 'cpu' " +
                        "AND server_name LIKE ?), " +
                        "'%', " +
                        "'C°')", usage, temperature, date, hostName);

    }

    public void memoryMeasurementInsertion(Long usage, String date, String hostName) {
        mssql.getMssql().update(
                "INSERT INTO " +
                        "[dbo].[measurement](usage, measurement_date, fk_component, usage_unit) " +
                        "VALUES (" +
                        "?, " +
                        "?, " +
                        "(SELECT id_component FROM [dbo].[component] " +
                        "INNER JOIN [dbo].[server] " +
                        "ON fk_server = id_server " +
                        "WHERE item LIKE 'ram' " +
                        "AND server_name LIKE ?), " +
                        "'B')", usage, date, hostName);

        mysql.getMysql().update(
                    "INSERT INTO " +
                        "dbo_measurement(measurement_usage, measurement_date, fk_component, usage_unit) " +
                        "VALUES (" +
                        "?, " +
                        "?, " +
                        "(SELECT id_component FROM dbo_component " +
                        "INNER JOIN dbo_server " +
                        "ON fk_server = id_server " +
                        "WHERE item LIKE 'ram' " +
                        "AND server_name LIKE ?), " +
                        "'B')", usage, date, hostName);
    }

}
