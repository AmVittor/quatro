package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.text.DecimalFormat;
import java.util.List;

public class HardwareData {
    SystemInfo systemInfo = new SystemInfo();
    OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    FileSystem fileSystem = operatingSystem.getFileSystem();
    List<OSFileStore> osFileStores = fileSystem.getFileStores();
    Looca looca = new Looca();
    private Double processorUsage;
    private Long diskUsage;
    private Long ramUsage;

    private DecimalFormat decimalFormat =  new DecimalFormat("0.00");

    public HardwareData() {
        this.processorUsage = 0.0;
        this.ramUsage = 0L;
        this.diskUsage = 0L;
    }

    public String getProcessorUsage() {
        return decimalFormat.format(this.processorUsage);
    }

    public String getDiskUsage() {
        return decimalFormat.format(this.diskUsage / 1024 / 1024/ 1024);
    }

    public String getRamUsage() {
        return decimalFormat.format(this.ramUsage / 1024 / 1024/ 1024);
    }

    public String getOperationalSystem() {
      return operatingSystem.getFamily();
    }

    public void setProcessorUsage(Double usage) {
        this.processorUsage = usage;
    }

    public void setRamUsage(Long usage) {
        this.ramUsage = usage;
    }

    public void setDiskUsage(Long usage) {
        this.diskUsage += usage;
    }
}
