package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    Button myButton2;
    Button myButton;
    TextView myTextView;
    Context context;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        myButton = findViewById(R.id.button1);
        myButton2 = findViewById(R.id.button3);
        myTextView = findViewById(R.id.textView1);
        final Toast myToast = new Toast(context);
        makeText(context, "I am a tast", LENGTH_SHORT).show();

        AlertDialog.Builder dialogconf = new AlertDialog.Builder(this);
        dialogconf.setTitle("Hi Dialog");
        dialogconf.setMessage("You sure?");
        dialogconf.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                myToast.makeText(context, "You clicked cancel", LENGTH_SHORT).show();
            }
        });
        dialogconf.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                myToast.makeText(context, "You clicked Yes", LENGTH_SHORT).show();
            }
        });

        dialogconf.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                myToast.makeText(context, "You clicked No", LENGTH_SHORT).show();
            }
        });        AlertDialog myDialog = dialogconf.create();
        myDialog.show();


        Notification.Builder notifBuilder = new Notification.Builder(this);
        notifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifBuilder.setContentTitle("This is my cool notif");
        notifBuilder.setContentText("This is the detail of my notif");


        Intent notificationIntent;

        notificationIntent = new Intent(this, ChildActivity.class);
        PendingIntent contentIntent =
                PendingIntent.getActivity(context, 0, notificationIntent,0);
        notifBuilder.setContentIntent(contentIntent);

        NotificationManager myNotification  = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(111, notifBuilder.build());



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