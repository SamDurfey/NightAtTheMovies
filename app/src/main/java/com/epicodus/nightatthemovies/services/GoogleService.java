package com.epicodus.nightatthemovies.services;

import android.util.Log;

import com.epicodus.nightatthemovies.Constants;
import com.epicodus.nightatthemovies.models.Theater;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoogleService {

    public static void findTheaters(/*String location,*/ Callback callback) {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GOOGLE_PLACES_TEST_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public ArrayList<Theater> processResults(Response response) {
        ArrayList<Theater> theaters = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject googleJSON = new JSONObject(jsonData);
                JSONArray theatersListJSON = googleJSON.getJSONArray("results");
                for (int i = 0; i < theatersListJSON.length(); i++) {
                    JSONObject theaterJSON = theatersListJSON.getJSONObject(i);
                    String name = theaterJSON.getString("name");
                    String reference = theaterJSON.getString("reference");
                    String placeId = theaterJSON.getString("place_id");

                    Theater theater = new Theater(name, reference, placeId);
                    theaters.add(theater);
                }
            }
        } catch (IOException e) {
            Log.d("hello", "I am the error");
            e.printStackTrace();
        } catch (JSONException e) {
            Log.d("Ignore him", "I'm the perpetrator");
            e.printStackTrace();
        }
        return theaters;
    }

}





















