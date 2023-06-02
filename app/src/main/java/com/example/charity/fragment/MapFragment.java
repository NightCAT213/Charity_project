package com.example.charity.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.bumptech.glide.Glide;
import com.example.charity.MainActivity;
import com.example.charity.R;
import com.example.charity.map.ImitationDB;
import com.example.charity.map.Place;
import com.example.charity.rest.MapsApiService;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.map_fragment, container, false);

        SupportMapFragment supportMapFragment=(SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                List<Place> places = ImitationDB.getPlaces();
                Log.e("f", String.valueOf(places.size()));
                for (Place p: places) {
                    googleMap.addMarker(new MarkerOptions().position(p.getLatLng()).title(p.getTitle()));
                }
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        Place place = ImitationDB.getPlaceByName(marker.getTitle());
                        Context context = getContext();
                        Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.dialog_fragment);
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.getWindow().setGravity(Gravity.BOTTOM);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();
                        TextView tv_name = dialog.getWindow().findViewById(R.id.tv_name);
                        TextView tv_address = dialog.getWindow().findViewById(R.id.tv_address);
                        TextView tv_info = dialog.getWindow().findViewById(R.id.tv_description);
                        ImageView btn_exit = dialog.getWindow().findViewById(R.id.iv2_productInfo_back);
                        btn_exit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.cancel();
                            }
                        });
                        tv_name.setText(place.getTitle());
                        tv_address.setText(place.getAddress());
                        tv_info.setText(place.getDescription());
                        return false;
                    }
                });
            }
        });
        // Return view
        return view;
    }
}





/*public class MapFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
        navBar.setVisibility(View.VISIBLE);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.google_map);
        //mapFragment.getMapAsync(new MapService(this));

        return view;
    }
}*/
