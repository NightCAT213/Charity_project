package com.example.charity.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charity.R;
import com.example.charity.domain.Product;
import com.example.charity.domain.Vacancy;
import com.example.charity.fragment.VacancyFragment;

import java.util.List;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyAdapter.ViewHolder> {

    private List<Vacancy> products;
    private Context context;
    private LayoutInflater layoutInflater;
    private VacancyFragment fragment;

    public VacancyAdapter(List<Vacancy> products, Context context, VacancyFragment fragment) {
        this.products = products;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.vacancy_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vacancy product = products.get(position);
        holder.name.setText(product.getTitle());
        holder.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "add " + product.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "clickekkeifjselfnwefwefunw");
                Uri uriUrl = Uri.parse(product.getPhone());
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                context.startActivity(launchBrowser);
            }
        });
        holder.cost.setText(product.getCost() + " руб");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        AppCompatButton bt_add;
        AbsoluteLayout layout;
        Button cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_vacancyItem_name);
            bt_add = itemView.findViewById(R.id.bt_vacancyItem_add);
            layout = itemView.findViewById(R.id.layoutvacancyitem);
            cost = itemView.findViewById(R.id.bt_vacancyItem_add);
        }
    }

}
