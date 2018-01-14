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
    public void json_test() throws Exception {
        String json_string = "{\n" +
                "\"language\": \"en\",\n" +
                "\"textAngle\": -2.0000000000000338,\n" +
                "\"orientation\": \"Up\",\n" +
                "\"regions\": [\n" +
                "{\n" +
                "\"boundingBox\": \"462,379,497,258\",\n" +
                "\"lines\": [\n" +
                "{\n" +
                "\"boundingBox\": \"462,379,497,74\",\n" +
                "\"words\": [\n" +
                "{\n" +
                "\"boundingBox\": \"462,379,41,73\",\n" +
                "\"text\": \"A\"\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"523,379,153,73\",\n" +
                "\"text\": \"GOAL\"\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"694,379,265,74\",\n" +
                "\"text\": \"WITHOUT\"\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"565,471,289,74\",\n" +
                "\"words\": [\n" +
                "{\n" +
                "\"boundingBox\": \"565,471,41,73\",\n" +
                "\"text\": \"A\"\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"626,471,150,73\",\n" +
                "\"text\": \"PLAN\"\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"801,472,53,73\",\n" +
                "\"text\": \"IS\"\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"519,563,375,74\",\n" +
                "\"words\": [\n" +
                "{\n" +
                "\"boundingBox\": \"519,563,149,74\",\n" +
                "\"text\": \"JUST\"\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"683,564,41,72\",\n" +
                "\"text\": \"A\"\n" +
                "},\n" +
                "{\n" +
                "\"boundingBox\": \"741,564,153,73\",\n" +
                "\"text\": \"WISH\"\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "]\n" +
                "}";
        JSONObject json = new JSONObject(json_string);
        Map<String,String> medical_records = JSON_Parser.main(json);
        System.out.println(medical_records);
    }
}