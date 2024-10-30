package com.example.pizzaexpressapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

private Context context;
private String[] itemNames;
private int[] itemIcons;

public MenuAdapter(Context context, String[] itemNames, int[] itemIcons) {
        this.context = context;
        this.itemNames = itemNames;
        this.itemIcons = itemIcons;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(itemNames[position]);
        holder.itemIcon.setImageResource(itemIcons[position]);

        // Evento de click para cada item
    if (position==2){
        holder.itemView.setOnClickListener(view -> {
        Intent intent = new Intent(context, cart.class);

        context.startActivity(intent);
        });
    }else {
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, subActivity.class);
            Log.i("indice", String.valueOf(position));
            intent.putExtra("index", position);
            context.startActivity(intent);
        });
    }

        }





@Override
public int getItemCount() {
        return itemNames.length;
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