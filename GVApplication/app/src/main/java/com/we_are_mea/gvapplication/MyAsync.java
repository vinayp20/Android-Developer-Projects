package com.we_are_mea.gvapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAsync extends AsyncTask<URL, String, String> {


    // you may separate this or combined to caller class.
    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public MyAsync(AsyncResponse delegate){
        this.delegate = delegate;
    }

    public MyAsync(AsyncResponse delegate,String apiUrl){
        this.delegate = delegate;
        this.apiUrl = apiUrl;

    }
    String apiUrl = null;
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        delegate.processFinish(result);
    }

    @Override
    protected String doInBackground(URL... params) {
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        String JSONData = null;
        JSONObject jsonObject = null;
        try {

            URL url = new URL(apiUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            System.out.println("Pearl Jam");
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);

            }
            bufferedReader.close();

            JSONData = buffer.toString();
//	     System.out.println(JSONData);

        } catch (
                MalformedURLException e
                )

        {
            e.printStackTrace();
        } catch (
                IOException e
                )

        {
            e.printStackTrace();
        }


//


        finally

        {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return JSONData;
    }


    /*protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Intent intent = new Intent(getApplicationContext(), DestinationActivity.class);
//
//
//        intent.putExtra("imageUri", movieDetails[position].imageUrl);
//
//        startActivity(intent);
    }*/
}

