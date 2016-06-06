package me.didik.task.app;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by didik on 06/06/16.
 * App
 */
public class TaskApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
