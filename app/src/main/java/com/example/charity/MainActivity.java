package com.example.charity;

import static java.lang.System.in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.charity.domain.Product;
import com.example.charity.domain.Vacancy;
import com.example.charity.fragment.MapFragment;
import com.example.charity.fragment.VacancyFragment;
import com.example.charity.fragment.HelperFragment;
import com.example.charity.fragment.SettingsFragment;
import com.example.charity.fragment.nonbasic.FiltrFragment;
import com.example.charity.map.ImitationDB;
import com.example.charity.map.Place;
import com.example.charity.rest.MapsApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bnv_main);
        View view = findViewById(R.id.nav_host_fragment);


        MapsApiService.getInstance().getAll3().enqueue(new Callback<List<Vacancy>>() {
            @Override
            public void onResponse(Call<List<Vacancy>> call, Response<List<Vacancy>> response) {
                System.out.println(response.body());
                System.out.println(response.body().get(0).getTitle());
                for (int i = 0; i < response.body().size(); i++) {
                    Vacancy p = new Vacancy(response.body().get(i).getId(),
                            response.body().get(i).getTitle(),
                            response.body().get(i).getDescription(),
                            response.body().get(i).getAddress(),
                            response.body().get(i).getPhone(),
                            response.body().get(i).getCost());
                    if (!DBImitation.allProducts.contains(p)) {
                        System.out.println(p.getTitle());
                        DBImitation.addTovacancy(p);
                    }
                }
                Log.e("fff", "Успех0");
            }

            @Override
            public void onFailure(Call<List<Vacancy>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Нет подключения к серверу", Toast.LENGTH_SHORT).show();
                Log.e("fff", "ERROR0");
                Log.e("fff", t.toString());
            }
        });


        List<Place> places = ImitationDB.getPlaces();

        MapsApiService.getInstance().getAll2().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                System.out.println(response.body());
                for (int i = 0; i < response.body().size(); i++) {
                    Place p = new Place(response.body().get(i).getId(),
                            response.body().get(i).getTitle(),
                            response.body().get(i).getDescription(),
                            response.body().get(i).getPicture(),
                            response.body().get(i).getAddress(),
                            response.body().get(i).getPhone(),
                            response.body().get(i).getCoords1(),
                            response.body().get(i).getCoords2());
                    Log.e("ff", p.getTitle());
                    places.add(p);
                }
                Log.e("fff", "Успех000");
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Нет подключения к серверу", Toast.LENGTH_SHORT).show();
                Log.e("fff", "ERROR0");
                Log.e("fff", t.toString());
            }
        });




        /*navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.full_screen_destination) {
                navigationView.setVisibility(View.GONE);
            } else {

                navigationView.setVisibility(View.VISIBLE);
            }
        }*/
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)
                        .getChildFragmentManager().getFragments().get(0);
                Log.e("rrr", "hereif000");
                if (currentFragment.getClass().equals(FiltrFragment.class)) {
                    Log.e("rrr", "hereif111");
                    navigationView.setVisibility(View.GONE);
                }
            }
        });*/
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)  {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)
                        .getChildFragmentManager().getFragments().get(0);
                /*if (currentFragment.getClass().equals(FiltrFragment.class)) {
                    Log.e("rrr", "hereif");
                    navigationView.setVisibility(View.GONE);
                }*/
                switch(item.getItemId()){
                    case(R.id.navigation_vacancy):
                        if(!currentFragment.getClass().equals(VacancyFragment.class)
                                && currentFragment.getClass().equals(HelperFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_helperFragment_to_vacancyFragment);
                        if(!currentFragment.getClass().equals(VacancyFragment.class)
                                && currentFragment.getClass().equals(SettingsFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_settingsFragment_to_vacancyFragment);
                        if(!currentFragment.getClass().equals(VacancyFragment.class)
                                && currentFragment.getClass().equals(MapFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_mapFragment_to_vacancyFragment);
                        return true;
                    case(R.id.navigation_map):
                        if(!currentFragment.getClass().equals(MapFragment.class)
                                && currentFragment.getClass().equals(HelperFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_helperFragment_to_mapFragment);
                        if(!currentFragment.getClass().equals(MapFragment.class)
                                && currentFragment.getClass().equals(SettingsFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_settingsFragment_to_mapFragment);
                        if(!currentFragment.getClass().equals(MapFragment.class)
                                && currentFragment.getClass().equals(VacancyFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_vacancyFragment_to_mapFragment);
                        return true;
                    case(R.id.navigation_helper):
                        if(!currentFragment.getClass().equals(HelperFragment.class)
                                && currentFragment.getClass().equals(VacancyFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_vacancyFragment_to_helperFragment);
                        if(!currentFragment.getClass().equals(HelperFragment.class)
                                && currentFragment.getClass().equals(SettingsFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_settingsFragment_to_helperFragment);
                        if(!currentFragment.getClass().equals(HelperFragment.class)
                                && currentFragment.getClass().equals(MapFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_mapFragment_to_helperFragment);
                        return true;
                    case(R.id.navigation_settings):
                        if(!currentFragment.getClass().equals(SettingsFragment.class)
                                && currentFragment.getClass().equals(VacancyFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_vacancyFragment_to_settigsFragment);
                        if(!currentFragment.getClass().equals(SettingsFragment.class)
                                && currentFragment.getClass().equals(HelperFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_helperFragment_to_settingsFragment);
                        if(!currentFragment.getClass().equals(SettingsFragment.class)
                                && currentFragment.getClass().equals(MapFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_mapFragment_to_settingFragment);
                        return true;
                }
                return false;
            }
        });
    }
}