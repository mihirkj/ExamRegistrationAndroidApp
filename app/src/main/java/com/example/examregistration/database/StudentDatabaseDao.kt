package com.example.examregistration.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDatabaseDao {

    @Insert
    fun insert(studData : StudentDetails)

    @Update
    fun update(studData: StudentDetails)

    @Query("SELECT * FROM student_details_table WHERE rollNo = :key")
    fun get(key : String): StudentDetails?

    @Query("SELECT * FROM student_details_table ORDER BY rollNo DESC LIMIT 1")
    fun getCurrentStudent(): StudentDetails?

    @Query("SELECT * FROM student_details_table")
    fun getAllStudents() : LiveData<List<StudentDetails>>

}