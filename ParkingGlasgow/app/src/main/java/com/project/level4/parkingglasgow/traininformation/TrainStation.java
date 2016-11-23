package com.project.level4.parkingglasgow.traininformation;

import android.location.GpsSatellite;

/**
 * Created by Rob on 11/23/16.
 */
public class TrainStation {
    GpsSatellite location;

    public TrainStation(GpsSatellite location){
        this.location = location;
    }

    public GpsSatellite getLocation(){
        return location;
    }
}
