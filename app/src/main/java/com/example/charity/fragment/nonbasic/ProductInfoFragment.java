package com.example.charity.fragment.nonbasic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.charity.DBImitation;
import com.example.charity.MainActivity;
import com.example.charity.R;
import com.example.charity.domain.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.http.Url;

public class ProductInfoFragment extends Fragment {

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_info_fragment, container, false);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bnv_main);
        navBar.setVisibility(View.GONE);
        long id = getArguments().getLong("prod_id");
        System.out.println("id!!!!!=" + id);
        Product product = DBImitation.findById(id);
        TextView tv_name = view.findViewById(R.id.tv_productInfo_name);
        ImageView image = view.findViewById(R.id.iv_productInfo);
        ImageView bt_back = view.findViewById(R.id.iv_productInfo_back);
        TextView tv_description = view.findViewById(R.id.tv_productInfo_description);
        TextView tv_cost = view.findViewById(R.id.tv_productInfo_cost);
        tv_cost.setText(product.getCost().toString() + " руб");
        Button btn_help = view.findViewById(R.id.btn_linkhelp);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uriUrl = Uri.parse(product.getLink());
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Ошибка загрузки", Toast.LENGTH_SHORT).show();
                    Log.e("toast", "now");
                }
            }
        });

        //image set

        Picasso.get().load(product.getPicture()).into(image);

        // end image set

        tv_description.setText(product.getDescription());
        tv_name.setText(product.getTitle());
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProductInfoFragment.this)
                        .navigate(R.id.action_productInfoFragment_to_helperFragment);
            }
        });
        return view;
    }
}
