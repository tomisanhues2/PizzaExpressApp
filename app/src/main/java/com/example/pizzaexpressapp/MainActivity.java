package com.example.pizzaexpressapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzaexpressapp.classes.AItems;
import com.example.pizzaexpressapp.classes.Drinks;
import com.example.pizzaexpressapp.classes.Foods;
import com.example.pizzaexpressapp.classes.Order;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static Set<AItems> items = new HashSet<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void generateItems() {
        //generate 5 food items

    }

    private void generateFoods(int quantity) {
        items.add(new Foods(1, "Pizza Margherita", R.drawable.food1, 10.99));
        items.add(new Foods(2, "Pizza Margherita", R.drawable.food2, 10.99));
        items.add(new Foods(3, "Pizza Margherita", R.drawable.food3, 10.99));
        items.add(new Foods(4, "Pizza Margherita", R.drawable.food4, 10.99));
        items.add(new Foods(5, "Pizza Margherita", R.drawable.food5, 10.99));

    }

    private void generateDrinks(int quantity) {
        items.add(new Drinks(1, "Coca Cola", R.drawable.drink1, 2.99));
        items.add(new Drinks(2, "Coca Cola", R.drawable.drink2, 2.99));
        items.add(new Drinks(3, "Coca Cola", R.drawable.drink3, 2.99));
        items.add(new Drinks(4, "Coca Cola", R.drawable.drink4, 2.99));
        items.add(new Drinks(5, "Coca Cola", R.drawable.drink5, 2.99));
    }
}