package com.smartcrop.backend.admin.dto;

public class DashboardStats {

    private long totalUsers;
    private long totalFarms;
    private long totalCrops;
    private long totalDiseases;
    private long totalYield;

    public DashboardStats(
            long totalUsers,
            long totalFarms,
            long totalCrops,
            long totalDiseases,
            long totalYield
    ) {
        this.totalUsers = totalUsers;
        this.totalFarms = totalFarms;
        this.totalCrops = totalCrops;
        this.totalDiseases = totalDiseases;
        this.totalYield = totalYield;
    }

    public long getTotalUsers() { return totalUsers; }
    public long getTotalFarms() { return totalFarms; }
    public long getTotalCrops() { return totalCrops; }
    public long getTotalDiseases() { return totalDiseases; }
    public long getTotalYieldRecords() { return totalYield; }
}
