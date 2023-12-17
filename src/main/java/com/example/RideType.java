package com.example;

public enum RideType {
    NORMAL(10.0, 1.0, 5.0),
    PREMIUM(15.0, 2.0, 20.0);

    final double FARE_PER_KM;
    final double FARE_PER_MIN;
    final double MINIMUM_FARE;

    RideType(double farePerKm, double farePerMin, double minimumFare) {
        this.FARE_PER_KM = farePerKm;
        this.FARE_PER_MIN = farePerMin;
        this.MINIMUM_FARE = minimumFare;
    }

    public double getFarePerKm() {
        return FARE_PER_KM;
    }

    public double getFarePerMin() {
        return FARE_PER_MIN;
    }

    public double getMinimumFare() {
        return MINIMUM_FARE;
    }
}

