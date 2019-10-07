package com.example.examregistration.database

import android.content.Context
import androidx.room.*
import androidx.room.Room.databaseBuilder


@Database(entities = [StudentDetails::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract val studentDatabaseDao: StudentDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getInstance(context: Context): StudentDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "student_details_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}