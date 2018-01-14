package com.ezhacks.ezhacks;

/**
 * Created by raiya on 2018-01-13.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Delete;
import java.util.List;

@Dao
public interface PatientDao {
    @Query("SELECT * FROM patients")
    List<Patient> getAll();

    @Query("SELECT * FROM patients WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Patient findByName(String first, String last);

    @Insert
    void insertAll(Patient... patients);

    @Delete
    void delete(Patient patient);
}
