package com.mycompany.quatro.measurement;

import com.mycompany.quatro.connection.ConnectionMysql;
import com.mycompany.quatro.connection.ConnectionSqlServer;

public class Insertion {

    ConnectionMysql mysql = new ConnectionMysql();
    ConnectionSqlServer mssql = new ConnectionSqlServer();

    public void diskMeasurementInsertion(Long usage, String date, String uuid) {
//        mysql.getMysql().update(
//                "INSERT INTO " +
//                        "measurement(usage, measurement_date, fk_component, usage_unit) " +
//                    "VALUES" +
//                        "(?, ?, ?, 'B')", usage, date, component);

        mssql.getMssql().update(
                "INSERT INTO "
                + "measurement(usage, measurement_date, fk_component, usage_unit) "
                + "VALUES"
                + "(?, ?, (select id_component from [dbo].[component] where UUID = '" + uuid + "'), 'B')", usage, date);
    }

    public void cpuMeasurementInsertion(Long usage, Double temperature, String date, Integer component) {
//        mysql.getMysql().update(
//                "INSERT INTO " +
//                        "measurement(usage, temperature, measurement_date, fk_component, usage_unit, temperature_unit) " +
//                        "VALUES" +
//                        "(?, ?, ?, ?, '%', 'ºC')", usage, temperature, date, component);

        mssql.getMssql().update(
                "INSERT INTO "
                + "measurement(usage, temperature, measurement_date, fk_component, usage_unit, temperature_unit) "
                + "VALUES"
                + "(?, ?, ?, ?, '%', 'ºC')", usage, temperature, date, component);
    }

    public void memoryMeasurementInsertion(Long usage, String date, Integer component) {
//        mysql.getMysql().update(
//                "INSERT INTO " +
//                        "measurement(usage, measurement_date, fk_component, usage_unit) " +
//                        "VALUES" +
//                        "(?, ?, ?, 'B')", usage, date, component);

        mssql.getMssql().update(
                "INSERT INTO "
                + "measurement(usage, measurement_date, fk_component, usage_unit) "
                + "VALUES"
                + "(?, ?, ?, 'B')", usage, date, component);
    }

}
