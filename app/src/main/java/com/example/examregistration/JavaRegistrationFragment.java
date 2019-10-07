package com.example.examregistration;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examregistration.database.StudDetails;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class JavaRegistrationFragment extends Fragment {

    private Button submitButton;
    private EditText RollNo, Name, Email;

    public JavaRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java_registration, container, false);

        RollNo = view.findViewById(R.id.rollNoEdit1);
        Name = view.findViewById(R.id.nameEdit1);
        Email = view.findViewById(R.id.emailEdit1);

        submitButton = view.findViewById(R.id.submitButton1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RollNo.getText().toString().trim().equals("")) {
                    RollNo.setError("Roll No. can't be empty");
                }

                else if (Name.getText().toString().trim().equals("")) {
                    Name.setError("Name can't be empty");
                }

                else if (TextUtils.isEmpty(Email.getText().toString()) ||
                        !Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
                    Email.setError("Invalid Email Address");
                }

                else {
                    int rollno = Integer.parseInt(RollNo.getText().toString());
                    String name = Name.getText().toString();
                    String email = Email.getText().toString();

                    if (validateRollno(rollno)) {

                        StudDetails stud = new StudDetails();
                        stud.setRollNo(rollno);
                        stud.setName(name);
                        stud.setEmail(email);

                        MainActivity.myAppDatabase.myDao().addStudent(stud);
                        Toast.makeText(getActivity(), "Student details added successfully!", Toast.LENGTH_SHORT).show();

                        RollNo.setText("");
                        Name.setText("");
                        Email.setText("");
                    }
                }
            }
        });

        return view;
    }

    boolean validateRollno(int rollno) {
        List<StudDetails> studs =  MainActivity.myAppDatabase.myDao().getStudents();
        String rolls = "";
        for(StudDetails stud: studs) {
            int roll = stud.getRollNo();
            rolls += " " + roll;
        }

        if (rolls.contains(Integer.toString(rollno))) {
            RollNo.setError("Already Registered!");
            return false;
        }

        else {
            RollNo.setError(null);
            return true;
        }
    }

}
