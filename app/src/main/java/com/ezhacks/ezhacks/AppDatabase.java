package com.ezhacks.ezhacks;

/**
 * Created by raiya on 2018-01-14.
 */

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;

@Database(entities = {Patient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PatientDao patientDao();
}
