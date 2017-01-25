package com.mah.newsma.dataprocess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mah on 1/25/2017.
 */

public class JsonParser {
    ArrayList<DataEncap> data;
    //one function
    public ArrayList<DataEncap> JsonProcess(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONObject mainObject = new JSONObject(jsonFile);

            JSONArray jsonArray = mainObject.getJSONArray("articles");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap encap = new DataEncap(mainObjectArray.getString(KeyTag.urlKey), mainObjectArray.getString(KeyTag.imgKey), mainObjectArray.getString(KeyTag.descKey), mainObjectArray.getString(KeyTag.titleKey));

                data.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<DataEncap> getlist() {
        return data;
    }
}
