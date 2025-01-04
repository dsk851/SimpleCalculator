package com.example.simplecalculator;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Authentification extends AppCompatActivity {
    TextView remove_person_action_text, add_person_action_text;
    Boolean Alight = false;
    FloatingActionButton remove_pers_fab, add_person_fab, add_fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authentification);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        remove_pers_fab = findViewById(R.id.remove_pers_fab);
        add_person_fab = findViewById(R.id.add_person_fab);
        add_person_action_text = findViewById(R.id.add_person_action_text);
        remove_person_action_text = findViewById(R.id.remove_person_action_text);
        add_fab = findViewById(R.id.add_fab);

        remove_pers_fab.setVisibility(View.GONE);
        add_person_fab.setVisibility(View.GONE);
        remove_person_action_text.setVisibility(View.GONE);
        add_person_action_text.setVisibility(View.GONE);
        add_fab.show();

        //Client client = new Client("Espoir", "john.c.breckinridge@altostrat.com", "password" );
//        DatabaseHelper dbHelper = new DatabaseHelper(this);
//        Client client = dbHelper.getClient(1);

//        if (client != null) {
//            // Afficher les informations du client dans un editext
//            EditText nameEditText = findViewById(R.id.name_edtext);
//            nameEditText.setText(client.getName());
//            EditText emailEditText = findViewById(R.id.email_edtext);
//            emailEditText.setText(client.getEmail());
//            EditText passwordEditText = findViewById(R.id.passwd_edtext);
//            passwordEditText.setText(client.getPassword());
//        }

        Button register = findViewById(R.id.register_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEditText = findViewById(R.id.name_edtext);
                EditText emailEditText = findViewById(R.id.email_edtext);
                EditText passwordEditText = findViewById(R.id.passwd_edtext);

                Client client = new Client(nameEditText.getText().toString(), emailEditText.getText().toString(), passwordEditText.getText().toString());
                DatabaseHelper dbHelper = new DatabaseHelper(Authentification.this);
                dbHelper.addClient(client);

                Intent intent = new Intent(Authentification.this, Login.class);
                startActivity(intent);

            }
        });

        Button login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Authentification.this, Login.class);
                startActivity(intent);

            }
        });

        add_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Alight) {

                    remove_pers_fab.setVisibility(View.VISIBLE);
                    add_person_fab.setVisibility(View.VISIBLE);
                    add_person_action_text.setVisibility(View.VISIBLE);
                    remove_person_action_text.setVisibility(View.VISIBLE);

                    Alight = true;
                } else {
                    remove_pers_fab.setVisibility(View.GONE);
                    add_person_fab.setVisibility(View.GONE);
                    remove_person_action_text.setVisibility(View.GONE);
                    add_person_action_text.setVisibility(View.GONE);

                    Alight = false;
                }
            }
        });

        add_person_fab.setOnClickListener(
                view -> Toast.makeText(Authentification.this, "Person Added", Toast.LENGTH_SHORT
                ).show());

        remove_pers_fab.setOnClickListener(
                view -> Toast.makeText(Authentification.this, "Person removed", Toast.LENGTH_SHORT
                ).show());

    }


}

