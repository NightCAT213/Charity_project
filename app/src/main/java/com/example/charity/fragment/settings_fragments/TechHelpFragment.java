package com.example.charity.fragment.settings_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.charity.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TechHelpFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tech_fragment, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
        navBar.setVisibility(View.GONE);

        ImageView btn_news = view.findViewById(R.id.iv6_productInfo_back);
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.charity.fragment.settings_fragments.TechHelpFragment.this)
                        .navigate(R.id.action_TechFragment_to_settingsFragment);
            }
        });

        return view;
    }
}