package com.example;

import java.util.List;

public class InvoiceGenerator {
    private static final double FARE_PER_KM = 10.0;
    private static final double FARE_PER_MIN = 1.0;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, double time) {
        double fare = distance * FARE_PER_KM + time * FARE_PER_MIN;
        return Math.max(fare, MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            double fare = ride.distance * ride.rideType.FARE_PER_KM + ride.time * ride.rideType.FARE_PER_MIN;
            totalFare += Math.max(fare, ride.rideType.MINIMUM_FARE);
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        int numRides = rides.length;
        double totalFare = calculateFare(rides);
        double avgFare = totalFare / numRides;
        return new Invoice(numRides, totalFare, avgFare);
    }

    public Invoice generateInvoiceForUser(int userId) {
        List<Ride> ridesList = RideRepository.getAllRides(userId);
        Ride[] rides = ridesList.toArray(new Ride[0]);
        return generateInvoice(rides);
    }
}

