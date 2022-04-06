package com.onesignal.notificationactivitybackstackexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class NotificationChannelFactory {
   private static final String CHANNEL_ID = "test_channel";
   private static final String CHANNEL_NAME = "Channel Name";

   @Nullable
   static String create(@NonNull final Context context) {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
         return null;

      NotificationChannel notificationChannel =
         new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

      NotificationManager notificationManager =
         (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
      notificationManager.createNotificationChannel(notificationChannel);

      return CHANNEL_ID;
   }
}
