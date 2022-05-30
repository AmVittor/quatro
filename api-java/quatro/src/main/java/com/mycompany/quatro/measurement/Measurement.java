 package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
//import com.mycompany.quatro.log.Logs;
import com.mycompany.quatro.slack.APP;
import com.mycompany.quatro.slack.Slack;
import org.json.JSONObject;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Measurement extends TimerTask {
    HardwareData hardware = new HardwareData();
    DecimalFormat decimalFormat = new DecimalFormat("00.##");
    //get data from disks
    SystemInfo systemInfo = new SystemInfo();
    OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    FileSystem fileSystem = operatingSystem.getFileSystem();
    List<OSFileStore> osFileStores = fileSystem.getFileStores();
    JSONObject json = new JSONObject();

    //looca api
    Looca looca = new Looca();
    Temperatura temperatura = new Temperatura();
    //date format
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //database insertion
    Insertion insertion = new Insertion();


    @Override
            public void run() {
//                Logs log = new Logs(dtf.format(now), looca.getProcessador().getUso(), looca.getMemoria().getEmUso());
                try {
                    insertion.cpuMeasurementInsertion(Math.round(looca.getProcessador().getUso()), temperatura.getTemperatura(), dtf.format(now), 1);
                    hardware.setProcessorUsage( looca.getProcessador().getUso());
                    insertion.memoryMeasurementInsertion(looca.getMemoria().getEmUso(), dtf.format(now), 2);
                    /*hardware.setRamUsage(looca.getMemoria().getEmUso());*/
                    hardware.setRamUsage(Double.valueOf(looca.getMemoria().getEmUso()));
                    System.out.println(looca.getProcessador().getUso());

                    if((looca.getProcessador().getUso()) <= (60.99)){
                        json.put("text",  "Sistema operando em sua funcionalidade normal");
                        Slack.sendMessage(json);
                    } else if ((looca.getProcessador().getUso()) <= 90.99){
                       json.put("text"," Está em alerta!, uso elevado ");
                       Slack.sendMessage(json);
                    } else {
                        json.put("text","ATENÇÃO  Está em uso extremo AÇÃO NECESSÁRIA ");
                       Slack.sendMessage(json);
                   }
                    System.out.println(looca.getProcessador().getUso());
                    System.out.println(looca.getMemoria().getEmUso());

                    for (OSFileStore fileStore : osFileStores) {
                        insertion.diskMeasurementInsertion((fileStore.getTotalSpace() - fileStore.getFreeSpace()), dtf.format(now), fileStore.getUUID());
                        /*hardware.setDiskUsage(fileStore.getTotalSpace() - fileStore.getFreeSpace());*/
                        hardware.setDiskUsage((double) (fileStore.getTotalSpace() - fileStore.getFreeSpace()));
                        DiskUsage diskUsage = new DiskUsage(fileStore.getUUID(), fileStore.getTotalSpace() - fileStore.getFreeSpace());
                        System.out.println(fileStore.getTotalSpace() - fileStore.getFreeSpace());
                       if(fileStore.getTotalSpace() - fileStore.getFreeSpace() <= (50.999999999)){
                           json.put("text", " Disco estável " + decimalFormat.format(looca.getProcessador().getUso()));
                           Slack.sendMessage(json);
                        } else if (fileStore.getTotalSpace() - fileStore.getFreeSpace() <= 90.999999999){
                            json.put("text"," Disco em alerta, uso elevado " + decimalFormat.format(looca.getProcessador().getUso()));
                           Slack.sendMessage(json);
                        } else {
                            json.put("text","ATENÇÃO  Disco está em uso extremo AÇÃO NECESSÁRIA " + decimalFormat.format(looca.getProcessador().getUso()));
                            Slack.sendMessage(json);
                       }
                       /* log.addDiskUsage(diskUsage);*/
                    }
//                    System.out.println(log);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

    public HardwareData getHardware() {
        return hardware;
    }
}
