package com.project.level4.parkingglasgow.parkinginformation;

import android.location.Location;

/**
 * Created by Rob on 11/23/16.
 */
public class ParkingLot implements Comparable <ParkingLot> {
    Location ParkingLotLocation;
    double duration;
    double pricePerHour;
    String name;
    int capacity;
    int parkedCars;
    String ParkingLoad;
    float distance;


    public ParkingLot(Location location, int capacity, int parkedCars, float distance, String name) {
        ParkingLotLocation = location;
        this.capacity = capacity;
        this.parkedCars = parkedCars;
        this.distance = distance;
        this.name = name;
    }

    public String getParkingLoad() {
        if ((capacity / parkedCars) <= 0.1) {
            ParkingLoad = "EMPTY";
        } else if ((capacity / parkedCars) <= 0.25) {
            ParkingLoad = "LIGHT";
        } else if ((capacity / parkedCars) <= 0.5) {
            ParkingLoad = "MODERATE";
        } else if ((capacity / parkedCars) <= 0.9) {
            ParkingLoad = "HEAVY";
        } else {
            ParkingLoad = "FULL";
        }
        return ParkingLoad;
    }

    public void setPricePerHour(double cost) {
        pricePerHour = cost;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCost() {
        return pricePerHour * duration;
    }

    // public void setDistance(float distancee) {
    //      distance = distancee;
    // }


    //Used to compare lots and sort (based upon distance from destination)
    @Override
    public int compareTo(ParkingLot compareLots) {

        float comparedistance = compareLots.distance;
        return (int)this.distance - (int)comparedistance;
    }

    public Location getLocation(){
        return ParkingLotLocation;
    }
}
