package com.ezhacks.ezhacks;

/**
 * Created by raiya on 2018-01-13.
 */


@Entity(tableName = "patients")
public class Patient {

    @PrimaryKey
    @ColumnInfo(name = "patient_id")
    private String pid;

    @ColumnInfo(name = "care_card")
    private String careCard;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "last_update")
    private Date date;

    // Constructor
    public Patient(String careCard, String firstName, String lastName) {
        this.pid = UUID.randomUUID().toString();
        this.careCard = careCard;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = new Date(System.currentTimeMillis());
    }
}
