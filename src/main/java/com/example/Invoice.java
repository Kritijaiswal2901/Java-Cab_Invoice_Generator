package com.example;

public class Invoice {
    private final int numRides;
    private final double totalFare;
    private final double averageFare;

    public Invoice(int numRides, double totalFare, double averageFare) {
        this.numRides = numRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getNumRides() {
        return numRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }
}

