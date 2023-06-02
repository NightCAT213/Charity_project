package com.example.charity;

import com.example.charity.domain.Product;
import com.example.charity.domain.Vacancy;

import java.util.ArrayList;

public class DBImitation {
    public static ArrayList<Product> allProducts = new ArrayList<>();
    public static ArrayList<Vacancy> vacancies = new ArrayList<>();
    public static ArrayList<Object> favs = new ArrayList<>();

    public static void setAllProducts(ArrayList<Product> allProducts) {
        DBImitation.allProducts = allProducts;
    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public static ArrayList<Vacancy> getVacancy() {
        return vacancies;
    }

    public static Product findById(long id){
        for (Product p: allProducts) {
            if(id == p.getId()) return p;
        }
        return null;
    }

    public static void addTovacancy(Vacancy product){
        vacancies.add(product);
    }
    public static void addProduct(Product product){
        allProducts.add(product);
    }
    public static void addFav(Object obj){
        favs.add(obj);
    }

}
