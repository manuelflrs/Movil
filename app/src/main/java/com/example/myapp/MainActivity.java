package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button myButton2;
    Button myButton;
    TextView myTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.button1);
        myButton = findViewById(R.id.button3);
        myTextView = findViewById(R.id.textView1);

        myTextView.setText("Hello folks");

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                myTextView.setText("You clicked me");

                Intent myIntent = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(myIntent);

            }
        });
        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                myTextView.setText("You clicked with dialog");

                Intent myIntent = new Intent(MainActivity.this, ChildActivity.class);
                myIntent.putExtra("myParam", "Mensaje myParamm");
                startActivity(myIntent);

            }
        });

    }
}