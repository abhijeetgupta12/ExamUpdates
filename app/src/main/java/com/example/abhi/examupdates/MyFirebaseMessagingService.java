package com.example.abhi.examupdates;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        
        generateNotification(remoteMessage.getNotification().getBody(),remoteMessage.getNotification().getTitle());
        
    }

    @Override
    public void onNewToken(String s) {

    }

    private void generateNotification(String body, String title) {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelID="ID";

            NotificationChannel channel = new NotificationChannel(channelID,"hello",NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(channel);

            builder.setChannelId(channelID);

        }

        notificationManager.notify(0,builder.build());

    }
}
