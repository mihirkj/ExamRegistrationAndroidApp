package com.example.examregistration.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student_details_table" )
data class StudentDetails (

    @PrimaryKey
    var rollNo: String,

    @ColumnInfo(name = "student_name")
    var name: String
)