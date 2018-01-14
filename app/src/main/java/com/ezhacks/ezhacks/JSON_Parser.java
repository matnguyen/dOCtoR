package com.ezhacks.ezhacks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
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

        try {
            JSONArray regions = json.getJSONArray("regions");
            for (int i = 0; i < regions.length(); i++) {
                JSONObject region = regions.getJSONObject(i);
                JSONArray lines = region.getJSONArray("lines");
                for (int j = 0; j < lines.length(); j++) {
                    JSONObject line = lines.getJSONObject(j);
                    JSONArray words = line.getJSONArray("words");
                    boolean attributeFlag = true; // Keeps track of when we are reading data field
                    String attribute = "";
                    String dataField = "";
                    for (int k = 0; k < words.length(); k++) {
                        JSONObject word = words.getJSONObject(k);
                        if (attributeFlag) {
                            attribute += (" " + word.getString("text"));
                            if (Arrays.asList(attributes).contains(attribute)) {
                                attributeFlag = false;
                            }
                        }
                        else {
                            dataField += (" " + word.getString("text"));
                        }
                    }
                    if (dataField == "") {
                        dataField = "N/A";
                    }
                    medicalRecords.put(attribute, dataField);
                }
            }
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

        return medicalRecords;
    }
}
