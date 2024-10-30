package com.example.pizzaexpressapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView productNameTextView;
    private TextView productPriceTextView;
    private EditText quantityEditText;
    private Button addToCartButton;
    private Button incrementButton;
    private Button decrementButton;
    private int quantity = 1; // Valor inicial de cantidad
    private ImageView productImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);


        productNameTextView = findViewById(R.id.productName);
        productPriceTextView = findViewById(R.id.productPrice);
        quantityEditText = findViewById(R.id.quantity);
        addToCartButton = findViewById(R.id.addToCartButton);
        incrementButton = findViewById(R.id.button_increment);
        decrementButton = findViewById(R.id.button_decrement);
        productImageView = findViewById(R.id.productImage);
        // Establecer valor inicial de cantidad en 1
        quantityEditText.setText(String.valueOf(quantity));

        String productName = getIntent().getStringExtra("productName");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0.0);
        int productImageId = getIntent().getIntExtra("productImage", -1);
        productNameTextView.setText(productName);
        productPriceTextView.setText("Price: $" + productPrice);
        if (productImageId != -1) {
            productImageView.setImageResource(productImageId);
        }
        // Configuración del botón de incrementar
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityEditText.setText(String.valueOf(quantity));
            }
        });

        // Configuración del botón de decrementar
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) { // Evita que el valor sea menor a 1
                    quantity--;
                    quantityEditText.setText(String.valueOf(quantity));
                } else {
                    Toast.makeText(ProductDetailActivity.this, "Cantidad mínima es 1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(productName, productPrice, quantity);
            }
        });
    }

    private void addToCart(String productName, double productPrice, int quantity) {
        // Lógica para agregar al carrito (ej. guardarlo en una lista o base de datos)
        MainActivity.cartItems.add(new MainActivity.Product(productName, quantity, productPrice));
        Toast.makeText(this, "Added to cart: " + productName + " x" + quantity, Toast.LENGTH_SHORT).show();
    }
}