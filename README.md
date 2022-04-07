## Summary
This project shows a bug some Android manufacturers (confirmed on Xiaomi devices)
have with their forked Android (AOSP) code. This specific bug is if the user swipes
away the app and taps on a notification. After the user presses the device's back button the app goes to the homescreen instead of following the app developer's intended back
stack.

## How to test my device for this bug?
1. Download the [NotificationActivityBackstackExampleIssue.apk](https://github.com/OneSignal/NotificationActivityBackstackExample/releases/tag/1.0.0) and install it on your Android device or emulator
you which to confirm the issue on.
   * Optionally you may clone this repo and build from source.
2. Simply open the app on your device and follow its instructs.
3. If you have this issue please share the details of the device by following the section below.

## Reporting the issue
Create a [new issue](https://github.com/OneSignal/NotificationActivityBackstackExample/issues/new) on this repo with the following details:
   * Please include all the details from Settings > About Phone such as MIUI version, android version, etc (screenshot works)
   * If Xiaomi Global device, verify your device with Xiaomi and include that status
https://www.mi.com/global/verify#/en/tab/imei
   * On Xiaomi devices include if the issue happens when “Display pop-up windows while running in the background” (older MIUI versions this is called “Start in background”) is enabled or disabled
   * Optional - Logcat, `adb shell dumpsys activity activities`, or any other useful outputs welcome to provide more details about the issue.
   * Optional - Video not required but helpful

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
_Xiaomi ROM bug, NOT an Android AOSP bug_

The back button behavior works in all cases except for Xiaomi devices
when the app is swiped away and it's Xiaomi specific “Display pop-up windows while running in the background” (older MIUI versions this is called “Start in background”)
permission is "Deny"(default) for the app.