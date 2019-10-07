package com.example.examregistration;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.examregistration.database.StudDetails;

public class javaDetailsFragment extends Fragment {

    private TextView txtInfo;
    private EditText RollNo;

    public javaDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java_details, container, false);

        txtInfo = view.findViewById(R.id.detailsview);

        String info = "";

        RollNo = getActivity().findViewById(R.id.givenRoll);
        int givRollNo = Integer.parseInt(RollNo.getText().toString());
        StudDetails stud = MainActivity.myAppDatabase.myDao().getStudent(givRollNo);
        info = "Roll No: " + stud.getRollNo() + "\n\nName: " + stud.getName() +
                "\n\nEmail: " + stud.getEmail();

        txtInfo.setText(info);

        return view;
    }

}
