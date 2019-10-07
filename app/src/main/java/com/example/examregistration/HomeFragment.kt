package com.example.examregistration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.examregistration.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)

        binding.regButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_javaRegistrationFragment)
        }

        binding.detailsButton.setOnClickListener { view : View ->
            val rollNo = activity!!.findViewById<EditText>(R.id.givenRoll)
            if (rollNo.text.toString().trim { it <= ' ' } == "") {
                rollNo.error = "Roll No. can't be empty"
            }
            else if (invalidRollno(Integer.parseInt(rollNo.text.toString()))) {
                rollNo.error = "Not Registered!"
            }
            else {
                rollNo.error = null
                view.findNavController().navigate(R.id.action_homeFragment_to_javaDetailsFragment)
            }
        }

        return binding.root
    }


    fun invalidRollno(rollno : Int) : Boolean {
        val studs = MainActivity.myAppDatabase.myDao().students
        var rolls = ""
        for (stud in studs) {
            val roll = stud.getRollNo()
            rolls += " $roll"
        }

        if (!rolls.contains(Integer.toString(rollno))) run(
            {
                return true
            })
        return false
    }

}
