package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.lab04.Notification.CHANNEL_ID;


public class MainActivity extends AppCompatActivity {

   private NotificationManagerCompat managerCompat;

   private Notification notification;

    Button signup;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerCompat = NotificationManagerCompat.from(this);

        signup = findViewById(R.id.buttonSignup);
        name = findViewById(R.id.editTextName);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = name.getText().toString();

                //go to register activity by click the notification
                Intent intent = new Intent(MainActivity.this, Register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Hello " + title + " !")
                        .setContentText("welcome to the MAD team")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        //.setContentIntent(contentIntent)
                        // Set the intent that will fire when the usertaps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(0, builder.build());


            }
        });

        }






    }

