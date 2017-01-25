package com.mah.newsma;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mah on 1/24/2017.
 */

public class Connector extends AsyncTask<String,String,String>{

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    StringBuilder sb = new StringBuilder();
    String data;



    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";

            while ((line = reader.readLine()) != null) {

                sb.append(line + "\n");
            }

            data = sb.toString();

        }
        catch (IOException e1) {
            e1.printStackTrace();
        }


        return data;
    }
}
