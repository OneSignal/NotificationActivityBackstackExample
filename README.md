## Summary
This project shows a bug some Android manufacturers (confirmed on Xiaomi devices)
have with their forked Android (AOSP) code. This specific bug is if the user swipes
away the app and taps on a notification. After the user presses the device's back button the app goes to the homescreen instead of following the app developers intended back
stack.

## How to test my device for this bug?
Simply build and run the app on your device and follow the instructs in the app.

## Details
This app creates a Notification with a `PendingIntent` that will open `TargetActivity` and put
`MainActivity` on the back stack. The parent is defined in the
`AndroidManifest.xml` of this app with `android:parentActivityName`
and the `<meta-data>` tag with `name="android.support.PARENT_ACTIVITY"`.

This follows the guidance outlined by Android's
"Start an Activity from a Notification" documentation for
"Regular activity".
Reference: https://developer.android.com/training/notify-user/navigation

## Issue Scenarios
_Xiaomi ROM bug, NOT an Android bug_

The back button behavior works in all cases except for Xiaomi devices
when the app is swiped away and it's Xiaomi specific "Start in background"
permission is "Deny"(default) for the app.