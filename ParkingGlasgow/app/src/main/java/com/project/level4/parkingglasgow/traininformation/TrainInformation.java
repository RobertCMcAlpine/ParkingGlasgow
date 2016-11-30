package com.project.level4.parkingglasgow.traininformation;

import android.content.Context;
import android.content.res.AssetManager;
import android.location.GpsSatellite;
import android.location.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainInformation {
    Location myLocation;
    Location destinationLocation;
    List<TrainStation> TrainStationList = new ArrayList<TrainStation>();
    String[] RowData;

    // used to instantiate TrainStationClass.
    public TrainInformation(Context context,Location myLocation, Location destinationLocation) {
        this.myLocation = myLocation;
        this.destinationLocation = destinationLocation;
        this.readCSV(context);
    }

    private TrainStation findNearestTrainStationToMe() {
        int arrayPosClosestStationToMe = 0;
        float currentItterationsDistance;
        Location iterationLocation;
        float lowestDistance = 999999999;

        for (int i = 0; i < TrainStationList.size(); i++) {
            iterationLocation = TrainStationList.get(i).location;
            currentItterationsDistance = getDistance(myLocation,iterationLocation);
            if (currentItterationsDistance < lowestDistance)
            {

                arrayPosClosestStationToMe = i;
                lowestDistance = currentItterationsDistance;
            }
        }
     return TrainStationList.get(arrayPosClosestStationToMe);
    }

    private TrainStation findNearestTrainStationToDestination() {
        int arrayPosClosestStationDest = 0;
        Location iterationLocation;
        float currentItterationsDistance;
        float lowestDistance = 999999999;

        for (int j = 0; j < TrainStationList.size(); j++) {
            iterationLocation = TrainStationList.get(j).location;
            currentItterationsDistance = getDistance(destinationLocation,iterationLocation);
            if (currentItterationsDistance < lowestDistance)
            {
                arrayPosClosestStationDest = j;
                lowestDistance = currentItterationsDistance;
            }
        }
        return TrainStationList.get(arrayPosClosestStationDest);
    }

    //Returns closest station to user. Currently returns name for testing.
    public String getNearestTrainStationToMe() {
        TrainStation nearestTrainStationM = findNearestTrainStationToMe();
        return nearestTrainStationM.Name;
    }

    //Returns closest station to destination. Currently returns name for testing.
    public String getNearestTrainStationDestination() {
        TrainStation nearestTrainStationD = findNearestTrainStationToDestination();
        return nearestTrainStationD.Name;
    }

    //returns Distance between two coordinates
    public float getDistance(Location destinationLocation, Location TrainStationLocation) {
        float distance = destinationLocation.distanceTo(TrainStationLocation);
        return distance;
    }


    public void readCSV(Context context) {

        TrainStation inputStation;
        AssetManager assetManager = context.getAssets();
        InputStream is = null;
        Location inputLocation = new Location("");
        String inputName;
        try {
            is = assetManager.open("subwayStops.csv");
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
                inputStation = new TrainStation(inputName,inputLocation);
                TrainStationList.add(inputStation);
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
}

}
