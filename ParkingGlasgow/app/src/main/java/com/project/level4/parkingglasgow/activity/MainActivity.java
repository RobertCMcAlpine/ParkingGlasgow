package com.project.level4.parkingglasgow.activity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.project.level4.parkingglasgow.parkinginformation.ParkingInfo;
import com.project.level4.parkingglasgow.traininformation.TrainInformation;
import com.project.level4.parkingglasgow.R;


/**
 * This will be starting page of app. Create further Activities (pages) for each screen of the app.
 * Code here is just hello world code that comes with creating a new project. Not my work or coding
 * for the app.
 *
 * layouts are created as xml in the res package under layout. feel free to start there before
 * any programming starts
 */
public class MainActivity extends AppCompatActivity {

    //For testing purposes
    ParkingInfo ParkingTest;
    TrainInformation TrainTest;
    Location currentLocation = new Location("");
    Location destinationLocation = new Location("");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        enableButtonListeners();

        currentLocation.setLatitude(55.86577732200993);
        currentLocation.setLongitude(-4.252559328401379);
        destinationLocation.setLatitude(55.86577732200993);
        destinationLocation.setLongitude(-4.252559328401379);
        ParkingTest = new ParkingInfo(MainActivity.this,destinationLocation);
        TrainTest = new TrainInformation(MainActivity.this,currentLocation,destinationLocation);
        Log.d("isParkingWorking?",ParkingTest.getParkingLot());
       Log.d("isTrainWorking?",TrainTest.getNearestTrainStationToMe());
        Log.d("isTrainWorking?",TrainTest.getNearestTrainStationDestination());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enableButtonListeners(){
        Button button1 = (Button) findViewById(R.id.route_plan_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.route_history_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 *
                 */
            }
        });
    }
}
