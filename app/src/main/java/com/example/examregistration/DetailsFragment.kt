package com.example.examregistration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.examregistration.database.*
import com.example.examregistration.databinding.FragmentDetailsBinding
import com.example.examregistration.examreg.ExamRegViewModel
import com.example.examregistration.examreg.ExamRegViewModelFactory
import com.example.examregistration.examreg.StudentDetailsAdapter
import kotlinx.android.synthetic.main.fragment_details.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater,
            R.layout.fragment_details,container,false)

       // myAppDatabse = Room.databaseBuilder(context.applicationContext, MyAppDatabase.class, name="studdb")

        val studs : List<StudDetails>
        //studs = MainActivity.myApp


        return binding.root
    }


}
