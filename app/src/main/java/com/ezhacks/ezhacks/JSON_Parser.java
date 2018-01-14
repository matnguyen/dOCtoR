package com.ezhacks.ezhacks;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matthew on 13/01/18.
 */

public class JSON_Parser {

    public static Map<String, String> main(JSONObject json) {
        Map<String, String> medicalRecords = new HashMap<>();
        String[] attributes = {"First name", "Last name", "Address", "City", "Province", "Postal code", "Date of birth",
                                "Gender", "Care card number", "Phone number", "Weight", "Height", "Heart rate", "Blood pressure",
                                "Body temperature"};

        for (String attribute : attributes) {

            try {
                String result = json.getString(attribute);
                medicalRecords.put(attribute, result);
            } catch (JSONException e) {
                System.out.println(e.getMessage());
                System.out.println(attribute+"failure\n");
            }
        }

        return medicalRecords;
    }
}
