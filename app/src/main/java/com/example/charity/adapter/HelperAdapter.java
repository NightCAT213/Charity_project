package com.example.charity.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charity.R;
import com.example.charity.domain.Product;
import com.example.charity.fragment.HelperFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.ViewHolder> {

    private List<Product> products;
    private Context context;
    private LayoutInflater layoutInflater;
    private HelperFragment fragment;

    public HelperAdapter(List<Product> products, Context context, HelperFragment fragment) {
        this.products = products;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.helper_item, parent, false);
        return new ViewHolder(view);
    }

    public void updateProducts(List<Product> products) {
        this.products.clear();
        for (int i = 0; i < products.size(); i++) {
            this.products.add(products.get(i));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.name.setText(product.getTitle());
        Picasso.get().load(product.getPicture()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putLong("prod_id", product.getId());
                NavHostFragment.findNavController(fragment).navigate(
                        R.id.action_helperFragment_to_productInfoFragment, bundle);
            }
        });
        holder.cost.setText(product.getCost().toString() + " руб");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        AppCompatButton cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_helperItem);
            name = itemView.findViewById(R.id.tv_helperItem_name);
            cost = itemView.findViewById(R.id.bt_helperItem_cost);
        }
    }

}
