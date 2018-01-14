package com.ezhacks.ezhacks;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.arch.persistence.room.Room;
import com.ezhacks.ezhacks.PatientDao;
import com.ezhacks.ezhacks.PatientDaoImpl;
import android.arch.persistence.room.Dao;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private View CapturePicButton;
    //private ImageView ImageStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View CapturePicButton = findViewById(R.id.Capture_button);
        //ImageView ImageStore = findViewById(R.id.picview);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            CapturePicButton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                System.out.println("Testing OCR\n");
                OCR_HTTP test_OCR = new OCR_HTTP();
//                test_OCR.OCR();
                new OCR_HTTP.OCR_request().execute();
            }
        });*/


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                CapturePicButton.setEnabled(true);
            }
        }
    }

    public void CapturePic(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    //    file = Uri.fromFile(getOutputMediaFile());
     //   intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, 100);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 100) {
//            if (resultCode == RESULT_OK) {
//                ImageStore.setImageURI(file);
//            }
//        }
//    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");
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
