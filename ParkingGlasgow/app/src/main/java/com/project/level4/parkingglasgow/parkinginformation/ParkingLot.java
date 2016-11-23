package com.project.level4.parkingglasgow.parkinginformation;

import android.location.GpsSatellite;

/**
 * Created by Rob on 11/23/16.
 */
public class ParkingLot {
    GpsSatellite ParkingLotLocation;
    double duration;
    double pricePerHour;
    int capacity;
    int parkedCars;
    private enum ParkingLoad{
        EMPTY, LIGHT, MODERATE, HEAVY, FULL
    };

    public ParkingLot(GpsSatellite location, int capacity, int parkedCars){
        ParkingLotLocation = location;
        this.capacity = capacity;
        this.parkedCars = parkedCars;
    }

    public void getParkingLoad(){
        // determine parking load from fraction of parked cars/capacity of car park
        // would suggest that 90% load of capacity would be determined as full, as a car park
        // will almost never be completely full, but the chances of getting any space might be
        // too small to consider..
        // use switch statement to determine this
    }

    public void setPricePerHour(double cost){
        pricePerHour = cost;
    }

    public void setDuration(double duration){
        this.duration = duration;
    }

    public double getCost(){
        return pricePerHour*duration;
    }
}
