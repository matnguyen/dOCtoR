package com.ezhacks.ezhacks;

/**
 * Created by Matthew on 13/01/18.
 */

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.net.URI;

// Obtained from Microsoft Cognitive Services Quick-start Guide
public class OCR_HTTP {
    // **********************************************
    // *** Update or verify the following values. ***
    // **********************************************

    // Replace the subscriptionKey string value with your valid subscription key.
    public static final String subscriptionKey = "dc35175256c5463b8556a42f4ea0ad83";

    // Replace or verify the region.
    //
    // You must use the same region in your REST API call as you used to obtain your subscription keys.
    // For example, if you obtained your subscription keys from the westus region, replace
    // "westcentralus" in the URI below with "westus".
    //
    // NOTE: Free trial subscription keys are generated in the westcentralus region, so if you are using
    // a free trial subscription key, you should not need to change this region.
    //
    // Also, if you want to use the celebrities model, change "landmarks" to "celebrities" here and in
    // uriBuilder.setParameter to use the Celebrities model.
    public static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/vision/v1.0/ocr";


    public static void OCR() // Args = String[] args?
    {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try
        {
//            System.out.println("OCR being called\n");
            // NOTE: You must use the same location in your REST call as you used to obtain your subscription keys.
            //   For example, if you obtained your subscription keys from westus, replace "westcentralus" in the
            //   URL below with "westus".
            URIBuilder uriBuilder = new URIBuilder(uriBase);

            uriBuilder.setParameter("language", "unk");
            uriBuilder.setParameter("detectOrientation ", "true");
//            System.out.println("Set parameters complete\n");

            // Request parameters.
            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);
//            System.out.println("Request parameters done\n");

            // Request headers.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
//            System.out.println("Request headers done\n");

            // Request body.
            StringEntity requestEntity =
                    new StringEntity("{\"url\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Atomist_quote_from_Democritus.png/338px-Atomist_quote_from_Democritus.png\"}");
            request.setEntity(requestEntity);
//            System.out.println("Request body finished\n");

            // Execute the REST API call and get the response entity.
            HttpResponse response = httpClient.execute(request);
            System.out.println("http request executed\n");
            HttpEntity entity = response.getEntity();
            System.out.println("Executed REST API\n");

            if (entity == null) {
                System.out.println("entity == null\n");
            }

            if (entity != null)
            {
                // Format and display the JSON response.
                String jsonString = EntityUtils.toString(entity);
                JSONObject json = new JSONObject(jsonString);
                System.out.println("REST Response:\n");
                System.out.println(json.toString(2));
            }
        }
        catch (Exception e)
        {
            // Display error message.
            System.out.println(e.getMessage());
        }
    }

    static class OCR_request extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... args) {
            OCR();
            return "";
        }

        protected void onPostExecute(String temp) {
            System.out.println("OCR complete\n");
        }
    }
}
