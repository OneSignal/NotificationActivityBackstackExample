package com.onesignal.notificationactivitybackstackexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

// TODO: Implement https://developer.android.com/training/notify-user/navigation

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      NotificationFactory.create(this);
   }
}
