package com.example.pizzaexpressapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class subActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] productNames;
    private int[] productIcons ; // Asigna el icono correspondiente a cada producto
    private double[] productPrices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);


        int index = getIntent().getIntExtra("index", -1);

        // Cargar productos según el índice seleccionado en el MainActivity
        switch (index) {
            case 0:
                productNames = new String[]{"Americano", "ColaCola", "Sprite", "DR Pepper","Fanta"};
                productPrices = new double[]{1200, 1000, 900, 2000,900}; // Precios de ejemplo
                productIcons = new int[] {R.drawable.drink1,R.drawable.drink2,R.drawable.drink3,R.drawable.drink4,R.drawable.drink5};
                break;
            case 1:
                productNames = new String[]{"Nugguets Pollo", "Big Mac", "Mc Pollo", "Barros Jarpa","Hamburguesa con queso"};
                productPrices = new double[]{2000, 3500, 2500,2000,1500}; // Precios de ejemplo
                productIcons = new int[] {R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5};

                break;
            // Agrega más categorías si es necesario
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductAdapter adapter = new ProductAdapter(this, productNames, productIcons, productPrices);
        recyclerView.setAdapter(adapter);

    }
}