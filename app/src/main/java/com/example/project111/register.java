// MainActivity.java
package com.example.project111;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private EditText etUsername, etPassword, etAlamat, etNomorHP;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Pastikan layout ini sesuai dengan file XML Anda

        etUsername = findViewById(R.id.etusername);
        etPassword = findViewById(R.id.etpassword);
        etAlamat = findViewById(R.id.etalamat);
        etNomorHP = findViewById(R.id.etnomorhp);
        btnRegister = findViewById(R.id.btnregister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String alamat = etAlamat.getText().toString();
                String nomorHP = etNomorHP.getText().toString();

                // Simpan data pengguna jika username dan password sesuai
                if (username.equals("irsyad26") && password.equals("312310512")) {
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.putString("alamat", alamat);
                    editor.putString("nomorhp", nomorHP);
                    editor.apply();

                    // Pindah ke activity Profile
                    Intent intent = new Intent(register.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(register.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
