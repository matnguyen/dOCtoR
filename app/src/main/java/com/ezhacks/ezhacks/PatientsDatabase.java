package com.ezhacks.ezhacks;

/**
 * Created by Shuman on 2018-01-13.
 */

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.TypeConverters;
import java.util.Date;
import java.text.SimpleDateFormat;


@Database(entities = {Patient.class}, version = 2)
//@TypeConverters(DateConverter.class)
public abstract class PatientsDatabase extends RoomDatabase {

    private static PatientsDatabase INSTANCE;

    public abstract PatientDao patientDao();
}