package com.example.examregistration.database;

import androidx.room.Database;

@Database(entities = {StudDetails.class}, version = 1, exportSchema = false)
public abstract class MyAppDatabase extends androidx.room.RoomDatabase {
    public abstract MyDao myDao();

}
