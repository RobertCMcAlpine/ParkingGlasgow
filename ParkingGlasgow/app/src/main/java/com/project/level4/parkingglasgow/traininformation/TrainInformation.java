package com.project.level4.parkingglasgow.traininformation;

import android.location.GpsSatellite;

/**
 * Created by Rob on 11/23/16.
 */

/**
 * you will have to dummy gps locations for developement, the app will pass real gps locations
 * into the methods when it is finished.
 *
 * these are my guesses as to how the classes to function, feel free to change as you wish
 *
 * if you require to make more classes, make sure you create them in the 'traininformation package'
 */
public class TrainInformation {
    GpsSatellite myLocation;
    GpsSatellite destinationLocation;
    TrainStation nearestTrainStationM;
    TrainStation nearestTrainStationD;

    // used to instantiate TrainStationClass.
    public TrainInformation(GpsSatellite myLocation, GpsSatellite destinationLocation){
        this.myLocation = myLocation;
        this.destinationLocation = destinationLocation;
    }

    protected void findNearestTrainStationToMe(){
        // TODO
        // set nearestTrainStationM here by determining it from myLocation
    }

    protected void findNearestTrainStationToDestination(){
        // TODO
        // set nearestTrainStationD here by determining it from destinationLocation
    }

    public TrainStation getNearestTrainStationToMe(){
        findNearestTrainStationToMe();
        return nearestTrainStationM;
    }

    public TrainStation getNearestTrainStationDestination(){
        findNearestTrainStationToDestination();
        return nearestTrainStationD;
    }


}
