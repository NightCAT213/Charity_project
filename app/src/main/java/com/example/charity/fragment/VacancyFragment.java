package com.example.charity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charity.DBImitation;
import com.example.charity.R;
import com.example.charity.adapter.VacancyAdapter;
import com.example.charity.domain.Product;
import com.example.charity.domain.Vacancy;
import com.example.charity.rest.MapsApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VacancyFragment extends Fragment {
    private VacancyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vacancy_fragment, container, false);

        //DBImitation.vacancies.clear();
        BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
        navBar.setVisibility(View.VISIBLE);
        /*MapsApiService.getInstance().getAll3().enqueue(new Callback<List<Vacancy>>() {
            @Override
            public void onResponse(Call<List<Vacancy>> call, Response<List<Vacancy>> response) {
                System.out.println(response.body());
                System.out.println(response.body().get(0).getTitle());
                for (int i = 0; i < response.body().size(); i++) {
                    Vacancy p = new Vacancy(response.body().get(i).getId(),
                            response.body().get(i).getTitle(),
                            response.body().get(i).getDescription(),
                            response.body().get(i).getAddress(),
                            response.body().get(i).getPhone());
                    DBImitation.addTovacancy(p);
                    adapter.notifyDataSetChanged();
                }
                Log.e("fff", "Успех0");
            }

            @Override
            public void onFailure(Call<List<Vacancy>> call, Throwable t) {
                Log.e("fff", "ERROR0");
                Log.e("fff", t.toString());
            }
        });*/
        RecyclerView recyclerView = view.findViewById(R.id.rv_vacancy);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        VacancyAdapter adapter = new VacancyAdapter(DBImitation.getVacancy(), getContext(), VacancyFragment.this);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
