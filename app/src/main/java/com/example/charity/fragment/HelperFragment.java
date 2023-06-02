package com.example.charity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charity.DBImitation;
import com.example.charity.R;
import com.example.charity.adapter.HelperAdapter;
import com.example.charity.fragment.nonbasic.FiltrFragment;
import com.example.charity.rest.MapsApiService;
import com.example.charity.domain.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HelperFragment extends Fragment {
    private HelperAdapter adapter;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DBImitation.allProducts.clear();
        View view = inflater.inflate(R.layout.helper_fragment, container, false);

        try {
            BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
            navBar.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Log.e("ohno", "error");
        }



        // btn
        Button btn_filtr = view.findViewById(R.id.btn_filtr);
        btn_filtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HelperFragment.this)
                        .navigate(R.id.action_helperFragment_to_filtrFragment);
            }
        });





        Log.e("fff", "oncreateview");

        MapsApiService.getInstance().getAll().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                System.out.println(response.body());
                System.out.println(response.body().get(0).getTitle());
                for (int i = 0; i < response.body().size(); i++) {
                    Product p = new Product(response.body().get(i).getId(),
                            response.body().get(i).getTitle(),
                            response.body().get(i).getCategory(),
                            response.body().get(i).getDescription(),
                            response.body().get(i).getPicture(),
                            response.body().get(i).getAddress(),
                            response.body().get(i).getPhone(),
                            response.body().get(i).getCoords1(),
                            response.body().get(i).getCoords2(),
                            response.body().get(i).getCost(),
                            response.body().get(i).getLink());
                    if (p.getCategory().equals(FiltrFragment.checks) ||
                            FiltrFragment.checks == "all") {
                        DBImitation.addProduct(p);
                    }
                    adapter.notifyDataSetChanged();
                }
                Log.e("fff", "Успех0");
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "Нет подключения к серверу", Toast.LENGTH_SHORT).show();
                Log.e("fff", "ERROR0");
                Log.e("fff", t.toString());
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.rv_helper);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new HelperAdapter(DBImitation.allProducts, getContext(), HelperFragment.this);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
