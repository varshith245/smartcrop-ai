package com.smartcrop.backend.admin.dto;

public class YieldAnalytics {

    private long totalRecords;
    private double totalYield;
    private double totalProfit;
    private double avgYield;

    public YieldAnalytics(
            long totalRecords,
            double totalYield,
            double totalProfit,
            double avgYield
    ) {
        this.totalRecords = totalRecords;
        this.totalYield = totalYield;
        this.totalProfit = totalProfit;
        this.avgYield = avgYield;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public double getTotalYield() {
        return totalYield;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public double getAvgYield() {
        return avgYield;
    }
}
