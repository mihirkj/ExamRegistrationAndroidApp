package com.example.examregistration.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "studs")
public class StudDetails {

    @PrimaryKey
    private int rollNo;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getEmail() { return this.email; }
}
