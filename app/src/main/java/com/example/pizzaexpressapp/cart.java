package com.example.pizzaexpressapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class cart extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private TextView totalTextView;
    private Button checkoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);


        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        totalTextView = findViewById(R.id.totalTextView);
        checkoutButton = findViewById(R.id.checkoutButton);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CartAdapter adapter = new CartAdapter(MainActivity.cartItems);
        cartRecyclerView.setAdapter(adapter);

        // Calcular el total acumulado
        double total = 0;
        for (MainActivity.Product product : MainActivity.cartItems) {
            total += product.totalPrice;
        }

        totalTextView.setText("Total: $" + total);

        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(cart.this, CheckoutActivity.class);
            startActivity(intent);
        });

    }

}