package com.example.pizzaexpressapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter  extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private String[] productNames;
    private int[] productIcons;
    private double[] productPrices;


    public ProductAdapter(Context context, String[] productNames, int[] productIcons, double[] productPrices) {
        this.context = context;
        this.productNames = productNames;
        this.productIcons = productIcons;
        this.productPrices = productPrices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(productNames[position]);
        holder.itemIcon.setImageResource(productIcons[position]); // Usa el mismo icono para todos

        holder.itemView.setOnClickListener(view -> {
            /*Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("productName", productNames[position]);
            intent.putExtra("productPrice", productPrices[position]);
            context.startActivity(intent);*/

            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("productName", productNames[position]);
            intent.putExtra("productPrice", productPrices[position]);
            intent.putExtra("productImage", productIcons[position]); // Reemplaza con el ID de la imagen adecuada
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemIcon;
        TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.item_icon);
            itemText = itemView.findViewById(R.id.item_text);
        }
    }
}