package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailEditText = findViewById(R.id.email_edtext);
                EditText passwordEditText = findViewById(R.id.passwd_edtext);
                Boolean checkCredentials = true;
                if (emailEditText.getText().toString().equals("") && passwordEditText.getText().toString().equals("")) {
                    Toast tost = Toast.makeText(Login.this, "Please enter email and password", Toast.LENGTH_SHORT);
                }
                DatabaseHelper dbHelper = new DatabaseHelper(Login.this);
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                checkCredentials = dbHelper.valideClient(email, password);

                if (!checkCredentials) {
                    Toast tost = Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_SHORT);
                    tost.show();
                }else {
                    Toast tost = Toast.makeText(Login.this, "Welcome", Toast.LENGTH_SHORT);
                    tost.show();

                    Intent intent = new Intent(Login.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });

        Button register = findViewById(R.id.register_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Authentification.class);
                startActivity(intent);
            }
        });

        }

}