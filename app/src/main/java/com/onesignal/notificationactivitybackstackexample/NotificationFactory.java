package com.onesignal.notificationactivitybackstackexample;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

class NotificationFactory {

   private static final int NOTIFICATION_ID = 1;
   private static final int UNIQUE_PENDING_INTENT_REQUEST_CODE = 1034765;

   static void create(@NonNull final Context context) {
      String channelId = NotificationChannelFactory.create(context);
      Notification notification = createNotification(context, channelId);
      NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification);
   }

   @NonNull
   private static Notification createNotification(
      @NonNull final Context context,
      @NonNull final String channelId
   ) {
      return new NotificationCompat.Builder(context, channelId)
         .setContentTitle("Activity backstack test")
         .setContentText("Tap me after swiping away the app")
         .setSmallIcon(android.R.drawable.ic_popup_reminder)
         .setContentIntent(createIntent(context))
         .build();
   }

   /**
    * This creates a PendingIntent that will open TargetActivity and put
    * MainActivity on the back stack. The parent is defined in the
    * AndroidManifest.xml of this app with android:parentActivityName
    * and the meta-data tag android.support.PARENT_ACTIVITY.
    *
    * This follows the guidance outlined by Android's
    * "Start an Activity from a Notification" documentation for
    * "Regular activity".
    * Reference: https://developer.android.com/training/notify-user/navigation
    *
    * BUG: Xiaomi ROM bug, NOT an Android bug
    * The back button behavior works in all cases except for Xiaomi devices
    * when the app is swiped away and it's Xiaomi specific "Start in background"
    * permission is "Deny"(default) for the app.
    */
   @NonNull
   private static PendingIntent createIntent(@NonNull final Context context) {
      Intent resultIntent  = new Intent(context, TargetActivity.class);
      return TaskStackBuilder.create(context)
         .addNextIntentWithParentStack(resultIntent)
         .getPendingIntent(
            UNIQUE_PENDING_INTENT_REQUEST_CODE,
            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
         );
   }
}
