package com.example.pc.kindakidz;

/**
 * Created by pc on 11/18/2017.
 */
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

public class Notification extends AppCompatActivity {


    public void sendNotification() {

//Get an instance of NotificationManager//
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.kid4)
                        .setContentTitle("Kk")
                        .setContentText("Lets play kid");

        NotificationManager mNotificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //NotificationManager.notify().

        mNotificationManager.notify(0, mBuilder.build());
    }
}




