// Profile.java
package com.example.project111;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class profile extends AppCompatActivity {
    private TextView usernameLabel;
    private EditText editUsername, editPassword, editAddress, editPhone;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameLabel = findViewById(R.id.username_label);
        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        editAddress = findViewById(R.id.edit_address);
        editPhone = findViewById(R.id.edit_phone);
        btnLogout = findViewById(R.id.btn_logout);


        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        String alamat = sharedPreferences.getString("alamat", "");
        String nomorhp = sharedPreferences.getString("nomorhp", "");


        usernameLabel.setText(username);
        editUsername.setText(username);
        editPassword.setText(password);
        editAddress.setText(alamat);
        editPhone.setText(nomorhp);


        btnLogout.setOnClickListener(v -> {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();


            Intent intent = new Intent(profile.this, register.class);
            startActivity(intent);
            finish();
        });
    }
}
