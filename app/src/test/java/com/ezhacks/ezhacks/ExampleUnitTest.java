package com.ezhacks.ezhacks;

import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    public void json_test() throws Exception {
        String json_string = "{\n" +
                "  \"First name\": \"John\",\n" +
                "  \"Last name\": \"Smith\",\n" +
                "  \"Address\": \"770 Sproule Avenue\",\n" +
                "  \"City\": \"Coquitlam\",\n" +
                "  \"Province\": \"BC\",\n" +
                "  \"Postal code\": \"V3J 4L5\",\n" +
                "  \"Date of birth\": \"14 March 1996\",\n" +
                "  \"Gender\": \"male\",\n" +
                "  \"Care card number\": \"12345\",\n" +
                "  \"Phone number\": \"604-446-1780\",\n" +
                "  \"Weight\": \"60\",\n" +
                "  \"Height\": \"6\",\n" +
                "  \"Heart rate\": \"60\",\n" +
                "  \"Blood pressure\": \"120/60\",\n" +
                "  \"Body temperature\": \"96\",\n" +
                "}";
        JSONObject json = new JSONObject(json_string);
        Map<String,String> medical_records = JSON_Parser.main(json);
    }
}