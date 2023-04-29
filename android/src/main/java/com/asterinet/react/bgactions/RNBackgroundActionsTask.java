package com.asterinet.react.bgactions;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;


final public class RNBackgroundActionsTask extends HeadlessJsTaskService {

    @SuppressLint("UnspecifiedImmutableFlag")
    @NonNull
    
    @Override
    protected @Nullable
    HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            return new HeadlessJsTaskConfig(extras.getString("taskName"), Arguments.fromBundle(extras), 0, true);
        }
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Bundle extras = intent.getExtras();
        if (extras == null) {
            throw new IllegalArgumentException("Extras cannot be null");
        }
        final BackgroundTaskOptions bgOptions = new BackgroundTaskOptions(extras);

        return super.onStartCommand(intent, flags, startId);
    }
}
