package com.ezhacks.ezhacks;

/**
 * Created by raiya on 2018-01-14.
 */

import java.util.List;
import java.util.ArrayList;

public class PatientDaoImpl implements PatientDao {

    List<Patient> patients;

    public PatientDaoImpl() {
        patients = new ArrayList<>();
//        patients.add(new Patient(1234, "Raiya", "Jessa"));
//        patients.add(new Patient(5678, "Shuman", "Peng"));
    }

    // retrieve list of patients from the database
    @Override
    public List<Patient> getAll() {
        return patients;
    }

    @Override
    public Patient findByCareCard(Integer careCard) {
        return patients.get(careCard);
    }

    @Override
    public void insert(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void delete(Patient patient) {
        patients.remove(patient);
    }
}
