package com.mycompany.quatro.log;

import oshi.software.os.OperatingSystem;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logs {

    Logger logger = Logger.getLogger("QuatroLogs");
    FileHandler fileHandler;

    public void generateMeasurementLog(
            OperatingSystem operatingSystem,
            String hostName,
            Double temperatura,
            Double usoCpu,
            Double frequenciaCpu,
            Double totalRam,
            Double usoRam) {
        String message = String.format(
                "[\n" +
                "Sistema Operacional: %s\n" +
                "Servidor: %s\n" +
                "Temperatura da CPU: %.2f\n" +
                "Uso da CPU: %.2f\n" +
                "Frequência da CPU: %.2f\n" +
                "Memória RAM total: %.2f\n" +
                "Memória RAM em uso: %.2f\n" +
                "]\n",
                operatingSystem, hostName, temperatura, usoCpu, frequenciaCpu, totalRam, usoRam
        );
        generate(message);
    }

    public void generateDiskLog(String uuid, Double totalSpace, Double diskUsage) {
         String message = String.format(
                 "[\n" +
                "UUID do disco: %s\n" +
                "Espaço total do disco: %.2f\n" +
                "Uso do disco: %.2f\n" +
                 "]\n",
                 uuid, totalSpace, diskUsage
        );
         generate(message);
    }

    public void generateLoginLog(String login, String password) {
        String message = String.format(
                "[\n" +
                "Fazendo login com as credenciais: \n" +
                "Login: %s\n" +
                "Senha: %s\n" +
                "]\n",
            login, password
        );
        generate(message);
    }

    public void generate(String message) {
        try {
            fileHandler = new FileHandler("../logs/QuatroLogs.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.info(message);

        } catch (SecurityException e) {
            logger.info("Exception:" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.info("IO Exception:" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }

    }
}