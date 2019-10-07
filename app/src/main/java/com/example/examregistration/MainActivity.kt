package com.example.examregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.examregistration.database.MyAppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAppDatabase = Room.databaseBuilder(
            applicationContext,
            MyAppDatabase::class.java, "studdb"
        ).allowMainThreadQueries().build()

    }

    companion object {
        lateinit var myAppDatabase: MyAppDatabase
    }
}
