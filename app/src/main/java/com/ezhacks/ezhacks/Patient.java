package com.ezhacks.ezhacks;

/**
 * Created by raiya on 2018-01-13.
 */

import java.util.UUID;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.support.annotation.NonNull;

@Entity(tableName = "patients")
public class Patient {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "patient_id")
    private String pid;

    @ColumnInfo(name = "care_card")
    private Integer careCard;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    // Constructor
    public Patient(Integer careCard, String firstName, String lastName) {
        this.pid = UUID.randomUUID().toString();
        this.careCard = careCard;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters

    public Integer getCareCard() {
        return this.careCard;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPid() {
        return this.pid;
    }

    public void setCareCard(Integer careCard) {
        this.careCard = careCard;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPid(String pid)  {
        this.pid = pid;
    }
}
