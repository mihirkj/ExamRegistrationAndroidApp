package com.example.examregistration.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addStudent(StudDetails stud);

    @Query("SELECT * FROM studs")
    List<StudDetails> getStudents();

    @Query("SELECT * FROM studs WHERE rollNo = :givenRoll")
    StudDetails getStudent(int givenRoll);
}
