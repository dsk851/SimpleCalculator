package com.example.simplecalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    EditText number3;

    Button somme;
    Button diff;
    Button prod;
    Button rapport;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.edtext1);
        number2 = findViewById(R.id.edtext2);
        number3 = findViewById(R.id.edtext3);

        somme = findViewById(R.id.btn1);
        diff = findViewById(R.id.btn2);
        prod = findViewById(R.id.btn3);
        rapport = findViewById(R.id.btn4);
        reset = findViewById(R.id.btn5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        number1.setText("");
        number2.setText("");
        number3.setText("");

        somme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1 = Integer.parseInt(number1.getText().toString());
                double num2 = Integer.parseInt(number2.getText().toString());

                double sum = num1 + num2;
                number3.setText(String.valueOf(sum));
            }
        });

        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1 = Integer.parseInt(number1.getText().toString());
                double num2 = Integer.parseInt(number2.getText().toString());

                double diff = num1 - num2;
                number3.setText(String.valueOf(diff));
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1 = Integer.parseInt(number1.getText().toString());
                double num2 = Integer.parseInt(number2.getText().toString());

                double prod = num1 * num2;
                number3.setText(String.valueOf(prod));
            }
        });

        rapport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1 = Integer.parseInt(number1.getText().toString());
                double num2 = Integer.parseInt(number2.getText().toString());

                double rap = num1 / num2;
                number3.setText(String.valueOf(rap));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number1.setText("");
                number2.setText("");
                number3.setText("");
            }
        });

    }

}