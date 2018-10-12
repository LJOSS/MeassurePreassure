package com.example.measurepressure;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = UserDB.class, version = 1,exportSchema = false)
public abstract class MyAppDB extends RoomDatabase {
    public abstract UserDAO myDAO();
}
