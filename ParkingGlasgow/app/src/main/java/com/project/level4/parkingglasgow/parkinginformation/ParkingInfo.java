package com.project.level4.parkingglasgow.parkinginformation;

import android.location.GpsSatellite;

/**
 * Created by Rob on 11/23/16.
 */

/**
 * you will have to dummy gps locations for development. The app will pass in real gps locations once
 * compete. It should not matter for developement. Figure out how to dummy gps locations and then start
 *
 * this is just my guess as to how these classes should funciton, feel free to change how you want.
 * If you need to add new classes, please create them inside the 'parkinginformation' package.
 *
 * NOTE/ also, these classes have incomplete,statements and will come up as errors!
 */
public class ParkingInfo {
    GpsSatellite destinatioLocation;

    public ParkingInfo(GpsSatellite destinationLocation){
        this.destinatioLocation = destinationLocation;
    }

    protected ParkingLot getNearestParkingLot(){
        ParkingLot parkingLot = new ParkingLot();
        // determine nearest parking lot, might be worth creating an array of nearest parking lots
        // that is sorted from nearest to furthest, then working through them with getParkingLot()
        // method.
        return parkingLot;
    }

    public ParkingLot getParkingLot(){
        /**
         *  boolean status = false;
         *  ParkingLot parkingLot = getNearestParkingLot()
         *  while status != true {
         *      if nearest parkingLot to destinationLocation isn't full/near full{
         *          use this parkingLot
         *          status = true;
         *      } else {
         *          find another parkingLot
         *      }
         *  }
         */
        // return parkingLot
    }
}
