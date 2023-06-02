package com.example.charity.fragment.settings_fragments;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.charity.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LastNewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
        navBar.setVisibility(View.GONE);

        ImageView btn_news = view.findViewById(R.id.iv7_productInfo_back);
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.charity.fragment.settings_fragments.LastNewsFragment.this)
                        .navigate(R.id.action_NewsFragment_to_settingsFragment);
            }
        });

        TextView t1 = view.findViewById(R.id.link1);
        t1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView t2 = view.findViewById(R.id.link2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}