package com.ezhacks.ezhacks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.arch.persistence.room.Room;
import com.ezhacks.ezhacks.PatientDao;
import com.ezhacks.ezhacks.PatientDaoImpl;
import android.arch.persistence.room.Dao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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


    public static void dbSetup() {
        // get instance of database
        // AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        // AppDatabase.class, "patients").build();
        PatientDao patientDao = new PatientDaoImpl();

        // create new patient
        Patient newPatient = new Patient(12345, "Raiya", "Jessa");

        // insert patient into 'patients' table
        patientDao.insert(newPatient);

        // query the db
        Patient res = patientDao.findByCareCard(12345);
        Log.d("Patient care card: ", res.getCareCard().toString());
    }

}
