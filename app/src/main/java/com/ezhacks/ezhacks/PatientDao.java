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

    @Query("SELECT * FROM patients WHERE care_card LIKE :careCard LIMIT 1")
    Patient findByCareCard(Integer careCard);

    @Insert
    void insert(Patient patient);

    @Delete
    void delete(Patient patient);
}
