package com.example.greendaodemo1;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application {
    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoManager.getInstance().init(getApplicationContext());
    }

}
