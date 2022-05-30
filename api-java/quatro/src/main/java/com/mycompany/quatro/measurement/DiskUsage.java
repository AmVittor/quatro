package com.mycompany.quatro.measurement;

public class DiskUsage {
    private String UUID;
    private Long usage;

    public DiskUsage(String UUID, Long usage) {
        this.UUID = UUID;
        this.usage = usage;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Long getUsage() {
        return usage;
    }

    public void setUsage(Long usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return String.format(
                "UUID= %s " +
                "USAGE= %d",
                this.UUID, this.usage
        );
    }
}
