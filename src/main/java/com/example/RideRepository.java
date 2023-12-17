package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RideRepository {
    private static final HashMap<Integer, List<Ride>> rideRepository = new HashMap<>();

    public static void addRide(int userId, Ride ride) {
        List<Ride> ridesList = rideRepository.computeIfAbsent(userId, k -> new ArrayList<>());
        ridesList.add(ride);
    }

    public static List<Ride> getAllRides(int userId) {
        return rideRepository.getOrDefault(userId, new ArrayList<>());
    }
}

