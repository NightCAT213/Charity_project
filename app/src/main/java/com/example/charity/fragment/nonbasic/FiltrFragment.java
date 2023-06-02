package com.example.charity.fragment.nonbasic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.charity.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FiltrFragment extends Fragment {
    public static String checks = "all";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filtr_fragment, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
        navBar.setVisibility(View.GONE);

        ImageView btn_news = view.findViewById(R.id.iv_productInfo_back);
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.charity.fragment.nonbasic.FiltrFragment.this)
                        .navigate(R.id.action_filtrFragment_to_helperFragment);
            }
        });
        RadioButton rb = null;

        if (checks == "all") {
            rb = view.findViewById(R.id.radio_all);
        } else if (checks == "elder") {
            rb = view.findViewById(R.id.radio_elder);
        } else if (checks == "adult") {
            rb = view.findViewById(R.id.radio_adult);
        } else if (checks == "child") {
            rb = view.findViewById(R.id.radio_child);
        } else if (checks == "animal") {
            rb = view.findViewById(R.id.radio_animal);
        } else if (checks == "ecology") {
            rb = view.findViewById(R.id.radio_ecology);
        }
        rb.setChecked(true);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch(id) {
                    case R.id.radio_all:
                        System.out.println("Все");
                        RadioButton rb1 = view.findViewById(R.id.radio_all);
                        checks = "all";
                        break;
                    case R.id.radio_elder:
                        System.out.println("Пожилые");
                        checks = "elder";
                        break;
                    case R.id.radio_adult:
                        System.out.println("Взрослые");
                        checks = "adult";
                        break;
                    case R.id.radio_child:
                        System.out.println("Дети");
                        checks = "child";
                        break;
                    case R.id.radio_animal:
                        System.out.println("Животные");
                        checks = "animal";
                        break;
                    case R.id.radio_ecology:
                        System.out.println("Экология");
                        checks = "ecology";
                        break;
                    default:
                        break;
                }
            }});

        super.onSaveInstanceState(savedInstanceState);
        return view;
    }
}
