package com.example.examregistration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.examregistration.database.StudentDatabase
import com.example.examregistration.databinding.FragmentRegistrationBinding
import com.example.examregistration.examreg.ExamRegViewModel
import com.example.examregistration.examreg.ExamRegViewModelFactory
import com.example.examregistration.examreg.StudentDetailsAdapter
import kotlinx.android.synthetic.main.fragment_registration.*


/**
 * A simple [Fragment] subclass.
 */
class RegistrationFragment : Fragment() {

    lateinit var inputRollno : String
    lateinit var inputName : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRegistrationBinding>(inflater,
            R.layout.fragment_registration,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = StudentDatabase.getInstance(application).studentDatabaseDao
        val viewModelFactory = ExamRegViewModelFactory(dataSource, application)
        val examRegViewModel = ViewModelProviders.of(this, viewModelFactory).
            get(ExamRegViewModel::class.java)
        binding.examRegViewModel = examRegViewModel

        binding.lifecycleOwner = this

        binding.submitButton.setOnClickListener { view : View ->
            inputRollno = rollnoEdit.text.toString()
            inputName = nameEdit.text.toString()
            examRegViewModel.onDetailsAdd(inputRollno, inputName)
        }


            return binding.root
    }



}
