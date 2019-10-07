package com.example.examregistration.examreg

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.examregistration.R
import com.example.examregistration.R.layout.fragment_details
import com.example.examregistration.database.StudentDatabaseDao
import com.example.examregistration.RegistrationFragment
import com.example.examregistration.database.StudentDetails
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.coroutines.*

public class ExamRegViewModel (
    val database: StudentDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val students = database.getAllStudents()

    val studentsStrings = students.toString()

    private var currentStudent = MutableLiveData<StudentDetails?>()

    init {
        initializeCurrentStudent()
    }

    private fun initializeCurrentStudent() {
        uiScope.launch {
            currentStudent.value = getCurrentStudentFromDatabase()
        }
    }

    private suspend fun getCurrentStudentFromDatabase() : StudentDetails? {
        return withContext(Dispatchers.IO) {
            var student = database.getCurrentStudent()
            if (student?.rollNo != student?.rollNo) {
                student = null
            }
            student
        }
    }

    fun onDetailsAdd(rollNo : String, name : String) {
        uiScope.launch {
            val newStudent = StudentDetails(rollNo, name)
            insert(newStudent)
            currentStudent.value = getCurrentStudentFromDatabase()
        }
    }

    private suspend fun insert(student: StudentDetails) {
        withContext(Dispatchers.IO) {
            database.insert(student)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    
    fun display() {
        val data : List<StudentDetails>
        val textView: TextView = (R.layout.fragment_details) as TextView
        textView.text = studentsStrings
    }
}