package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.mycompany.quatro.log.Logs;
import com.mycompany.quatro.slack.Slack;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimerTask;

public class Measurement extends TimerTask {
    HardwareData hardware = new HardwareData();
    SystemInfo systemInfo = new SystemInfo();
    OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    Looca looca = new Looca();
    Temperatura temperatura = new Temperatura();
    LocalDateTime now;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    Insertion insertion = new Insertion();
    String hostName;
    List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();
    Long volumeUsage;
    Long volumeTotalUsage = 0L;
    Logs log = new Logs();

    public void run() {
        this.now = LocalDateTime.now();

        try {
            this.hostName = InetAddress.getLocalHost().getHostName();
            insertion.cpuMeasurementInsertion(looca.getProcessador().getUso(), temperatura.getTemperatura(), dtf.format(now), this.hostName);
            hardware.setProcessorUsage(looca.getProcessador().getUso());
            insertion.memoryMeasurementInsertion(looca.getMemoria().getEmUso(), dtf.format(now), this.hostName);
            hardware.setRamUsage(looca.getMemoria().getEmUso());
            Slack.validateCpuUsage(looca.getProcessador().getUso());
            Slack.validateRamUsage(Double.valueOf(looca.getMemoria().getEmUso()), Double.valueOf(looca.getMemoria().getTotal()));

            log.generateMeasurementLog(
                    operatingSystem, hostName, temperatura.getTemperatura(),
                    looca.getProcessador().getUso(), Double.valueOf(looca.getProcessador().getFrequencia()), Double.valueOf(looca.getMemoria().getTotal()),
                    Double.valueOf(looca.getMemoria().getEmUso()));

            for (Volume volume : volumes) {
                volumeUsage = volume.getTotal() - volume.getDisponivel();
                volumeTotalUsage += volumeUsage;
                insertion.diskMeasurementInsertion(volumeUsage, dtf.format(now), volume.getUUID(), this.hostName);
                Slack.validateDiskUsage(Double.valueOf(volumeUsage), Double.valueOf(volume.getTotal()));
                log.generateDiskLog(volume.getUUID(), Double.valueOf(volume.getTotal()), Double.valueOf(volumeUsage));
            }
            hardware.setDiskUsage(volumeTotalUsage);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HardwareData getHardware() {
        return hardware;
    }
}