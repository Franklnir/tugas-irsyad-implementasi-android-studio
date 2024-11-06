package com.example.project111;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;


    private final String correctUsername = "irsyad26";
    private final String correctPassword = "312310512";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsername = findViewById(R.id.etusername);
        etPassword = findViewById(R.id.etpassword);
        btnLogin = findViewById(R.id.btnlogin);
        btnRegister = findViewById(R.id.btnregister);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();


                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    Toast.makeText(login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
    }
}
