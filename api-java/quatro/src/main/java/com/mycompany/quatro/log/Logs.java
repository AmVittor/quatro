package com.mycompany.quatro.log;
package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.quatro.connection.Main;
import com.mycompany.quatro.login.User;
import com.mycompany.quatro.measurement.DiskUsage;
import com.mycompany.quatro.measurement.HardwareData;
import com.mycompany.quatro.measurement.Measurement;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Logs extends Measurement{
    public static void main(String[] args) {


        User user = new User();
        Double alertaRam = 10.00;
        Integer alertaCpu = 50;
        Integer alertaDisco = 0;
        Looca looca = new Looca();
        HardwareData hardware = new HardwareData();
        
        
       

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("src/main/resources/MyLogFile.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.info("Log to test");
            if (user.getEmail() != user.getEmail() || user.getPassword() != user.getPassword()) {
                logger.info("E-mail ou senha incorretos");
            } else {
                 logger.info("Login Realizado com Sucesso");
            }



          
        } catch (SecurityException e) {
            logger.info("Exception:" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.info("IO Exception:" + e.getMessage());
            e.printStackTrace();
           
            
            
            // memoria
        } if (looca.getMemoria().getEmUso() <= alertaRam ) {
            logger.info("Alerta: Memoria esta ok");     
        } else {
            logger.info("Alerta: Memoria esta no limite");  
        } 
        
           // cpu
        if (looca.getProcessador().getUso() <= alertaCpu) {
            logger.info("Alerta: Processador esta ok ");
        }else{
            logger.info("Alerta: Processador esta no limite");
        }
        

           // disco...   
        if (looca.getGrupoDeDiscos().getQuantidadeDeVolumes()<= alertaDisco) {
            logger.info("Alerta: disco esta ok");
        } else{
            logger.info("Alerta: Disco esta no limite");
        }

}
}

        