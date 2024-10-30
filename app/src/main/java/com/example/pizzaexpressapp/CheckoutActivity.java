package com.example.pizzaexpressapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckoutActivity extends AppCompatActivity {
    private RadioGroup deliveryMethodRadioGroup;
    private RadioButton pickupRadioButton;
    private RadioButton deliveryRadioButton;
    private LinearLayout addressLayout;
    private EditText nameEditText, phoneEditText, addressEditText, cityEditText, zipCodeEditText;
    private Button confirmOrderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);


        deliveryMethodRadioGroup = findViewById(R.id.deliveryMethodRadioGroup);
        pickupRadioButton = findViewById(R.id.pickupRadioButton);
        deliveryRadioButton = findViewById(R.id.deliveryRadioButton);
        addressLayout = findViewById(R.id.addressLayout);
        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        cityEditText = findViewById(R.id.cityEditText);
        zipCodeEditText = findViewById(R.id.zipCodeEditText);
        confirmOrderButton = findViewById(R.id.confirmOrderButton);

        // Mostrar u ocultar la sección de dirección
        deliveryMethodRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.deliveryRadioButton) {
                addressLayout.setVisibility(View.VISIBLE);
            } else {
                addressLayout.setVisibility(View.GONE);
            }
        });

        confirmOrderButton.setOnClickListener(v -> confirmOrder());
    }

    private void confirmOrder() {
        // Validación básica
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        if (name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        if (deliveryRadioButton.isChecked()) {
            String address = addressEditText.getText().toString();
            String city = cityEditText.getText().toString();
            String zipCode = zipCodeEditText.getText().toString();

            if (address.isEmpty() || city.isEmpty() || zipCode.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos de la dirección", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        Toast.makeText(this, "Pedido confirmado", Toast.LENGTH_SHORT).show();
        // Aquí podrías redirigir a otra pantalla o guardar los datos del pedido.
    }
}