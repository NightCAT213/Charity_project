package com.example.charity.map;

import android.os.Build;
import android.util.Log;

import com.example.charity.rest.AppApi;
import com.example.charity.rest.MapsApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class ImitationDB {

    public static ArrayList<Place> places = new ArrayList<>();
    public static ArrayList<Place> getPlaces() {
        return places;
    }
    public static Place getPlaceByName(String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return places.stream().filter(p -> p.getTitle().equals(name)).findAny()
                    .orElseThrow(() -> new RuntimeException("не найдено"));
        }
        else{
            for (Place p:
                    places) {
                if(p.getTitle().equals(name)) return p;
            }
        }
        return null;
    }

}