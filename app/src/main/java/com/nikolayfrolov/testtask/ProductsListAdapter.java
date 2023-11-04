package com.nikolayfrolov.testtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {
    private Context context;
    private final LayoutInflater layoutInflater;
    private final List<ProductsList> productsLists;

    ProductsListAdapter(Context context, List<ProductsList> productsLists)    {
        this.context = context;
        this.productsLists = productsLists;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.pizza_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsList productsList = productsLists.get(position);

        holder.product_photo.setBackgroundResource(productsList.getProduct_photo());
        holder.product_title.setText(productsList.getProduct_title());
        holder.product_ingredients.setText(productsList.getProduct_ingredients());
        holder.product_price.setText(productsList.getProduct_start_price());
    }

    @Override
    public int getItemCount() {
        return productsLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        Button button;
        ImageView product_photo;
        TextView product_title;
        TextView product_ingredients;
        Button product_price;
        public ViewHolder(View view)    {
            super(view);

            product_photo = view.findViewById(R.id.pizza_photo);
            product_title = view.findViewById(R.id.pizza_title);
            product_ingredients = view.findViewById(R.id.pizza_ingredients);
            product_price = view.findViewById(R.id.pizza_price);

        }
    }

}
