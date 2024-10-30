package com.example.pizzaexpressapp;

import android.app.Application;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaexpressapp.classes.AItems;
import com.example.pizzaexpressapp.classes.Drinks;
import com.example.pizzaexpressapp.classes.Foods;
import com.example.pizzaexpressapp.classes.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static Set<AItems> items = new HashSet<>();
    private RecyclerView recyclerView;
    public static List<Product> cartItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateItems();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos de ejemplo
        String[] itemNames = {"¿Algo para tomar?", "¿Algo para comer?", "¿Listo para ordenar?"};
        int[] itemIcons = {R.drawable.drink1, R.drawable.food1, R.drawable.ic_launcher_foreground};

        MenuAdapter adapter = new MenuAdapter(this, itemNames, itemIcons);
        recyclerView.setAdapter(adapter);

    }



    private void generateItems() {
        //generate 5 food items
        generateFoods(5);
        //generate 5 drink items
        generateDrinks(5);

    }

    private void generateFoods(int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(new Foods(i, "Pizza", R.drawable.food1, 10.99));
        }
    }

    private void generateDrinks(int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(new Drinks(i, "Coke", R.drawable.drink1, 1.99));
        }
    }



    public static class Product {
        String name;
        int quantity;
        double unitPrice;
        double totalPrice;

        public Product(String name, int quantity, double unitPrice) {
            this.name = name;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.totalPrice = quantity * unitPrice;
        }
    }
}