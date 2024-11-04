package com.example.project111;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText searchBar;
    private LinearLayout burgerItem, rendangItem, susuGandumItem, rotiGandumItem;
    private Button spicyButton, healthyButton, veganButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen dari XML
        searchBar = findViewById(R.id.search_bar);
        burgerItem = findViewById(R.id.foodItemBurger);
        rendangItem = findViewById(R.id.foodItemRendang);
        susuGandumItem = findViewById(R.id.foodItemSusuGandum);
        rotiGandumItem = findViewById(R.id.foodItemRotiGandum); // Pastikan item ini diinisialisasi
        spicyButton = findViewById(R.id.spicyButton);
        healthyButton = findViewById(R.id.healthyButton);
        veganButton = findViewById(R.id.veganButton);

        // Mengatur fungsionalitas pencarian
        setupSearchFunctionality();
        // Mengatur filter tombol
        setupButtonFilters();
        // Mengatur listener klik untuk item
        setupItemClickListeners();

        // Inisialisasi dan menambahkan onClickListener pada ikon profil
        ImageView profileIcon = findViewById(R.id.profileIcon);
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk membuka activity_profile.xml
                Intent intent = new Intent(MainActivity.this, profile.class);
                startActivity(intent);
            }
        });
    }

    private void setupSearchFunctionality() {
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String query = charSequence.toString().toLowerCase();
                filterItemsBySearch(query);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void filterItemsBySearch(String query) {
        // Menampilkan atau menyembunyikan item berdasarkan pencarian
        burgerItem.setVisibility(query.contains("burger") ? View.VISIBLE : View.GONE);
        rendangItem.setVisibility(query.contains("rendang") ? View.VISIBLE : View.GONE);
        susuGandumItem.setVisibility(query.contains("susu gandum") ? View.VISIBLE : View.GONE);
        rotiGandumItem.setVisibility(query.contains("roti gandum") ? View.VISIBLE : View.GONE);
    }

    private void setupButtonFilters() {
        spicyButton.setOnClickListener(v -> filterItems("burger"));
        healthyButton.setOnClickListener(v -> filterItems("susu gandum"));
        veganButton.setOnClickListener(v -> filterItems("roti gandum"));
    }

    private void filterItems(String filter) {
        // Menampilkan atau menyembunyikan item berdasarkan tombol filter yang dipilih
        burgerItem.setVisibility(filter.equals("burger") ? View.VISIBLE : View.GONE);
        rendangItem.setVisibility(filter.equals("rendang") ? View.VISIBLE : View.GONE);
        susuGandumItem.setVisibility(filter.equals("susu gandum") ? View.VISIBLE : View.GONE);
        rotiGandumItem.setVisibility(filter.equals("roti gandum") ? View.VISIBLE : View.GONE);
    }

    private void setupItemClickListeners() {
        // Menangani klik pada setiap item makanan
        burgerItem.setOnClickListener(v -> openRecipeActivity(resep_burger.class));
        rendangItem.setOnClickListener(v -> openRecipeActivity(resep_rendang.class));
        susuGandumItem.setOnClickListener(v -> openRecipeActivity(susu_gandum.class));
        rotiGandumItem.setOnClickListener(v -> openRecipeActivity(rotigandum.class));
    }

    private void openRecipeActivity(Class<?> activityClass) {
        // Membuka aktivitas resep yang sesuai
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
