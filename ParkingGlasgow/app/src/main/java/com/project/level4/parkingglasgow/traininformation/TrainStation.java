package com.project.level4.parkingglasgow.traininformation;

import android.location.GpsSatellite;
import android.location.Location;

import com.project.level4.parkingglasgow.parkinginformation.ParkingLot;

/**
 * Created by Rob on 11/23/16.
 */


public class TrainStation {
    Location location;
    String Name;

    public TrainStation(String Name, Location location) {
        this.location = location;
        this.Name = Name;
    }

    public Location getLocation() {
        return location;
    }
}
