package com.example.measurepressure;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserDB.class, MeassureDB.class}, version = 1, exportSchema = false)
public abstract class MyAppDB extends RoomDatabase {
    public abstract UserDAO userDAO();

    public abstract MeassureDAO meassureDAO();

    private static volatile MyAppDB INSTANCE;

    static MyAppDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyAppDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyAppDB.class,
                            "MyDB")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
