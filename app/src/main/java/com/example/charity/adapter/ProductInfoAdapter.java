package com.example.charity.adapter;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charity.R;
import com.example.charity.domain.Product;

public class ProductInfoAdapter extends RecyclerView.Adapter<ProductInfoAdapter.ViewHolder>{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        Button help;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            help = itemView.findViewById(R.id.btn_linkhelp);
        }
    }
}






















/*
public class ProductInfoAdapter extends RecyclerView.Adapter<ProductInfoFragment.ViewHolder>{
    @NonNull
    @Override
    public ProductInfoFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductInfoFragment.ViewHolder holder, int position) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView notes;
        TextView favourites;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notes = itemView.findViewById(R.id.bt_notes);
            favourites = itemView.findViewById(R.id.bt_favourites);
        }
    }
}
*/
