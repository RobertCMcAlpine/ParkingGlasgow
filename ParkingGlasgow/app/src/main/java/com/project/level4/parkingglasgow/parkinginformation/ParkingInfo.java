package com.project.level4.parkingglasgow.parkinginformation;
import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.location.Location;

/*
/**
 * Created by Rob on 11/23/16.
 */

public class ParkingInfo {


    List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    Location destinationLocation;
    String[] RowData;

    public ParkingInfo(Context context,Location destinationLocation)
    {
        this.destinationLocation = destinationLocation;
        this.readCSV(context);
    }


    //Determines nearest non-full parking lot

    private ParkingLot findParkingLot()
    {
        int i = 0;
        for (; i < parkingLotList.size(); i++) {
            if ( (parkingLotList.get(i).getParkingLoad() != "Full"))
            {
                break;
            }
        }
        return parkingLotList.get(i);
    }


    public String getParkingLot() {
        ParkingLot closestLot = findParkingLot();
       // return closestLot;
        return closestLot.name;
    }

    public Location getLocationOfParkingLot() {
        ParkingLot closestLot = findParkingLot();
        return closestLot.getLocation();
    }

    //Provides absolute distance between two coords, does not take into account road paths
    public float getDistance(Location destinationLocation, Location parkingLotLocation)
    {
        float distance =  destinationLocation.distanceTo(parkingLotLocation);
        return distance;
    }




    private void readCSV(Context context){
     AssetManager assetManager = context.getAssets();
     InputStream is = null;
       Location inputLocation = new Location("");
        float inputDistance;
        int inputParkedCars;
        int inputCapacity;
        String inputName;

        try {
            is = assetManager.open("carParks.csv");
        } catch (IOException e) {
        e.printStackTrace();
        }

        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));


        try {
        String line;
        while ((line = reader.readLine()) != null) {
        RowData = line.split(",");

          inputLocation.setLatitude(Float.valueOf((String)RowData[1]));
            inputLocation.setLongitude(Float.valueOf((String)RowData[2]));
            inputName = RowData[0];
            inputDistance = getDistance(destinationLocation,inputLocation);
            inputParkedCars = Integer.valueOf(RowData[3]);
            inputCapacity = Integer.valueOf(RowData[4]);

           ParkingLot test = new ParkingLot(inputLocation,inputCapacity,inputParkedCars,inputDistance,inputName);
             parkingLotList.add(test);
        }
        }
        catch (IOException ex) {
        // handle exception
        }
        finally {
        try {
        is.close();
        }
        catch (IOException e) {
        // handle exception
        }
        }
        //Sort parkingLotList in descending order for distance
        Collections.sort(parkingLotList);
        return;
    }
}
