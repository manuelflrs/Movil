package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    Button myButton;
    Intent i;
    TextView myTextView;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        i = getIntent();
        String auxString;
        context = getApplicationContext();
        auxString = i.getStringExtra("myParam");
        myTextView = findViewById(R.id.textView1);
        myButton = findViewById(R.id.button2);
        myTextView.setText(auxString);






        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){


                Intent myIntent = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(myIntent);

            }
        });


    }
}