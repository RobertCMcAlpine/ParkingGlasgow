package com.project.level4.parkingglasgow.walkinginformation;

import android.location.GpsSatellite;

/**
 * Created by Rob on 11/23/16.
 */
public class Walk {
    GpsSatellite myLocation;
    GpsSatellite destinationLocation;

    public Walk(GpsSatellite myLocation, GpsSatellite destinationLocation){
        this.myLocation = myLocation;
        this.destinationLocation = destinationLocation;
    }

    public double getTimeToArrival(){
        double time = 0;
        double speed = 0;

        // TODO
        // Given two locations, determine time to reach location from speed of walking (3mph) between
        // two locations. Should be possible with google maps apis.
        return (0);
    }
}
