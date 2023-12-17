package com.example;

public class Ride {
    private final int userId;
    final double distance;
    final double time;
    final RideType rideType;

    public Ride(int userId, double distance, double time, RideType rideType) {
        this.userId = userId;
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;

        RideRepository.addRide(userId, this);
    }

    public int getUserId() {
        return userId;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public RideType getRideType() {
        return rideType;
    }
}
